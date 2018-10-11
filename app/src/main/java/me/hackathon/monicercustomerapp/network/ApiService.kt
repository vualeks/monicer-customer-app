package me.hackathon.monicercustomerapp.network

import androidx.lifecycle.LiveData
import me.hackathon.monicercustomerapp.vo.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("api/auth/token")
    fun authenticate(@Body authenticationRequest: AuthenticationRequest):
            LiveData<ApiResponse<AuthenticationResponse>>

    @GET("api/wallet")
    fun getMyWallet():
            LiveData<ApiResponse<TransactionResponse>>

    @GET("api/me")
    fun getUser(): LiveData<ApiResponse<User>>
}