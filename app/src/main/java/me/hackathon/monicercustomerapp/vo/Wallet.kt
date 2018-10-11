package me.hackathon.monicercustomerapp.vo

import com.google.gson.annotations.SerializedName

data class Wallet(

        @SerializedName("address")
        val address: Int,

        @SerializedName("balance")
        var balance: Int,

        @SerializedName("owner")
        var owner: Owner
)