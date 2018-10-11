package me.hackathon.monicercustomerapp.vo

import com.google.gson.annotations.SerializedName

data class AuthenticationResponse(
        @SerializedName("access_token")
        val accessToken: String? = null,

        @SerializedName("token_type")
        val tokenType: String? = null
)
