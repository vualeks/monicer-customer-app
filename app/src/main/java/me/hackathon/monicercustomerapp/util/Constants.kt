package me.hackathon.monicercustomerapp.util

import androidx.lifecycle.MutableLiveData
import me.hackathon.monicercustomerapp.vo.User

object Constants {
    const val BASE_URL = "http://192.168.2.117:8080/"

    lateinit var CURRENT_USER: User

    val payCodeLiveData = MutableLiveData<String>()
}