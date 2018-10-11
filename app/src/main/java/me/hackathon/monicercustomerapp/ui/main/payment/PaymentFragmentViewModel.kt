package me.hackathon.monicercustomerapp.ui.main.payment

import androidx.lifecycle.ViewModel
import me.hackathon.monicercustomerapp.network.ApiService
import javax.inject.Inject

class PaymentFragmentViewModel @Inject constructor(private val api: ApiService): ViewModel() {
    fun getUser() = api.getUser()
}