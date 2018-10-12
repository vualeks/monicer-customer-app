package me.hackathon.monicercustomerapp.vo

import com.google.gson.annotations.SerializedName

data class PaymentConfirmationEvent(
    @SerializedName("payCode") val newPayCode: String,
    @SerializedName("returnedAmount") val returnedAmount: Double,
    @SerializedName("transacrion") val transaction: Transaction
)