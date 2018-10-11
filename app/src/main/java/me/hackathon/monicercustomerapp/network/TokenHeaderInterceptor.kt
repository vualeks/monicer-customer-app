package me.hackathon.monicercustomerapp.network

import me.hackathon.monicercustomerapp.util.Constants.BASE_URL
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class TokenHeaderInterceptor : Interceptor {
    var token: String = ""

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response =
            chain.proceed(chain.request().newBuilder()
                    .apply {
                        if (!token.isEmpty() && chain.request().url().toString().contains(BASE_URL))
                            addHeader("Authorization", "Bearer $token")
                    }.build())
}
