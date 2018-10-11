package me.hackathon.monicercustomerapp.ui.main.payment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_payment.*
import kotlinx.android.synthetic.main.fragment_payment_container.*
import me.hackathon.monicercustomerapp.R
import me.hackathon.monicercustomerapp.ui.main.payment.pay.PayFragment
import me.hackathon.monicercustomerapp.ui.main.payment.split.SplitFragment
import me.hackathon.monicercustomerapp.util.Constants.CURRENT_USER
import me.hackathon.monicercustomerapp.util.CustomViewModelFactory
import me.hackathon.monicercustomerapp.util.TabAdapter
import net.glxn.qrgen.android.QRCode
import javax.inject.Inject

class PaymentFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: CustomViewModelFactory
    private lateinit var viewModel: PaymentFragmentViewModel
    private lateinit var adapter: TabAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_payment, container, false)!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PaymentFragmentViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        payment_qr_code.setImageBitmap(QRCode.from(CURRENT_USER.payCode).bitmap())

        payment_pay_credit.setOnClickListener {
            payment_root.visibility = View.GONE
            payment_container.visibility = View.VISIBLE
            initTabLayout()
        }

        payment_container_back.setOnClickListener {
            payment_container.visibility = View.GONE
            payment_root.visibility = View.VISIBLE
        }
    }

    private fun initTabLayout() {
        adapter = TabAdapter(activity!!.supportFragmentManager)
        adapter.addFragment(PayFragment(), resources.getString(R.string.pay))
        adapter.addFragment(SplitFragment(), resources.getString(R.string.split_bill))
        payment_container_viewPager.adapter = adapter
        payment_container_tab_layout.setupWithViewPager(payment_container_viewPager)
    }
}