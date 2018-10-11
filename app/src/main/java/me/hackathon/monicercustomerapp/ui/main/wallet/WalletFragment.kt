package me.hackathon.monicercustomerapp.ui.main.wallet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sothree.slidinguppanel.SlidingUpPanelLayout
import com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_wallet.balance
import kotlinx.android.synthetic.main.fragment_wallet.cashback
import kotlinx.android.synthetic.main.fragment_wallet.dragView
import kotlinx.android.synthetic.main.fragment_wallet.loading
import kotlinx.android.synthetic.main.fragment_wallet.root
import kotlinx.android.synthetic.main.fragment_wallet.transactions_list
import me.hackathon.monicercustomerapp.R
import me.hackathon.monicercustomerapp.util.CustomViewModelFactory
import java.util.Locale
import javax.inject.Inject

class WalletFragment : DaggerFragment(), SlidingUpPanelLayout.PanelSlideListener {

    @Inject
    lateinit var viewModelFactory: CustomViewModelFactory
    private lateinit var viewModel: WalletFragmentViewModel
    private lateinit var adapter: TransactionsAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_wallet, container, false)!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(WalletFragmentViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)

        linearLayoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        transactions_list.layoutManager = linearLayoutManager
        transactions_list.slideLayout = root
        transactions_list.setScrollingEnabled(false)
        root.addPanelSlideListener(this)

        transactions_list.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(
                recyclerView: RecyclerView,
                dx: Int,
                dy: Int
            ) {
                super.onScrolled(recyclerView, dx, dy)
                if (linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0) {

                }
            }
        })
    }

    override fun onResume() {
        super.onResume()

        loading.visibility = View.VISIBLE
        viewModel.getMyWallet().observe(this, Observer {
            loading.visibility = GONE
            balance.text = String.format(Locale.ITALIAN, "%.2f", it.body?.wallet?.balance)
            cashback.text = String.format(Locale.ITALIAN, "%.2f", it.body?.saved_money)

            adapter = TransactionsAdapter(it.body?.transactions!!)
            transactions_list.adapter = adapter
        })
    }

    override fun onPanelSlide(
        panel: View?,
        slideOffset: Float
    ) {

    }

    override fun onPanelStateChanged(
        panel: View?,
        previousState: PanelState?,
        newState: PanelState?
    ) {
        transactions_list.setScrollingEnabled(newState == SlidingUpPanelLayout.PanelState.EXPANDED)
        if (newState == SlidingUpPanelLayout.PanelState.EXPANDED) dragView.background =
            ContextCompat.getDrawable(activity?.applicationContext!!, R.drawable.transactions_rect)
        else dragView.background =
            ContextCompat.getDrawable(activity?.applicationContext!!, R.drawable.transactions_rounded)
    }
}