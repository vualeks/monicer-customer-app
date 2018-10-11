package me.hackathon.monicercustomerapp.ui.main.wallet

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_wallet.balance
import kotlinx.android.synthetic.main.fragment_wallet.cashback
import kotlinx.android.synthetic.main.fragment_wallet.loading
import me.hackathon.monicercustomerapp.R
import me.hackathon.monicercustomerapp.util.CustomViewModelFactory
import java.util.Locale
import javax.inject.Inject

class WalletFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: CustomViewModelFactory
    private lateinit var viewModel: WalletFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_wallet, container, false)!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(WalletFragmentViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onResume() {
        super.onResume()

        loading.visibility = View.VISIBLE
        viewModel.getMyWallet().observe(this, Observer {
            loading.visibility = GONE
            balance.text = String.format(Locale.ITALIAN, "%.2f", it.body?.wallet?.balance)
            cashback.text = String.format(Locale.ITALIAN, "%.2f", it.body?.saved_money)
        })
    }
}