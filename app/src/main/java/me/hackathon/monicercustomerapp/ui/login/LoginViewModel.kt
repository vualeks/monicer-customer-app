package me.hackathon.monicercustomerapp.ui.login

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import me.hackathon.monicercustomerapp.network.ApiService
import me.hackathon.monicercustomerapp.network.TokenHeaderInterceptor
import me.hackathon.monicercustomerapp.util.Constants.CURRENT_USER
import me.hackathon.monicercustomerapp.vo.AuthenticationRequest
import me.hackathon.monicercustomerapp.vo.AuthenticationResponse
import javax.inject.Inject

class LoginViewModel @Inject constructor(
        private val api: ApiService,
        private val tokenHeaderInterceptor: TokenHeaderInterceptor) : ViewModel() {

    var email = ObservableField("")
    var password = ObservableField("")

    fun authenticate() = api.authenticate(AuthenticationRequest(email.get()!!, password.get()!!))

    fun initUser(authResponse: AuthenticationResponse) {
        tokenHeaderInterceptor.token = authResponse.accessToken
        CURRENT_USER = authResponse.user
    }
}