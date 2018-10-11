package me.hackathon.monicercustomerapp.vo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Owner {

  @SerializedName("id")
  @Expose
  var id: Int? = null
  @SerializedName("name")
  @Expose
  var name: String? = null
  @SerializedName("email")
  @Expose
  var email: String? = null
  @SerializedName("pay_code")
  @Expose
  var pay_code: String? = null

}