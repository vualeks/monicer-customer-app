package me.hackathon.monicercustomerapp.ui.main.payment.pay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_pay.*
import me.hackathon.monicercustomerapp.R
import me.hackathon.monicercustomerapp.ui.main.payment.PaymentFragmentViewModel
import me.hackathon.monicercustomerapp.util.CustomViewModelFactory
import net.glxn.qrgen.android.QRCode
import javax.inject.Inject

class PayFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: CustomViewModelFactory
    private lateinit var viewModel: PaymentFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_pay, container, false)!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PaymentFragmentViewModel::class.java)

        viewModel.getUser().observe(this, Observer { user ->
            if (user.isSuccessful)
                pay_qr_code.setImageBitmap(QRCode.from(user.body?.payCode).bitmap())
        })
    }
}