package me.hackathon.monicercustomerapp.ui.main.payment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import me.hackathon.monicercustomerapp.R
import me.hackathon.monicercustomerapp.util.CustomViewModelFactory
import javax.inject.Inject
import kotlinx.android.synthetic.main.fragment_payment.*
import net.glxn.qrgen.android.QRCode

class PaymentFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: CustomViewModelFactory
    private lateinit var viewModel: PaymentFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_payment, container, false)!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PaymentFragmentViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        payment_qr_code.setImageBitmap(QRCode.from("www.example.org").bitmap())
    }
}