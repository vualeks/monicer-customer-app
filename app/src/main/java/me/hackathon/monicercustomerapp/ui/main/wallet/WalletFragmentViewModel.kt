package me.hackathon.monicercustomerapp.ui.main.wallet

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import me.hackathon.monicercustomerapp.R.string.password
import me.hackathon.monicercustomerapp.network.ApiService
import me.hackathon.monicercustomerapp.vo.AuthenticationRequest
import javax.inject.Inject

class WalletFragmentViewModel @Inject constructor(private val api: ApiService): ViewModel() {
  var balance = ObservableField("")

  fun getMyWallet() = api.getMyWallet()
}