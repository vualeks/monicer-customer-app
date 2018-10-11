package me.hackathon.monicercustomerapp.network

import androidx.lifecycle.LiveData
import me.hackathon.monicercustomerapp.vo.ApiResponse
import me.hackathon.monicercustomerapp.vo.AuthenticationRequest
import me.hackathon.monicercustomerapp.vo.AuthenticationResponse
import me.hackathon.monicercustomerapp.vo.TransactionResponse
import me.hackathon.monicercustomerapp.vo.Wallet
import retrofit2.http.*

interface ApiService {
    @POST("api/auth/token")
    fun authenticate(@Body authenticationRequest: AuthenticationRequest):
            LiveData<ApiResponse<AuthenticationResponse>>

    @GET("api/wallet")
    fun getMyWallet():
        LiveData<ApiResponse<TransactionResponse>>
}