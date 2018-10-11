package me.hackathon.monicercustomerapp.ui.main.payment.split

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_split.*
import me.hackathon.monicercustomerapp.R
import me.hackathon.monicercustomerapp.ui.main.payment.PaymentFragmentViewModel
import me.hackathon.monicercustomerapp.ui.scan.ScanActivity
import me.hackathon.monicercustomerapp.util.CustomViewModelFactory
import javax.inject.Inject

class SplitFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: CustomViewModelFactory
    private lateinit var viewModel: PaymentFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_split, container, false)!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PaymentFragmentViewModel::class.java)
        split_join.setOnClickListener {
            startActivity(Intent(context, ScanActivity::class.java))
        }
    }
}