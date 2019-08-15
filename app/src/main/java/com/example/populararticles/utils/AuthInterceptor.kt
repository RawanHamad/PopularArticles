package com.example.populararticles.utils

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor constructor(private val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newUrl = chain.request().url()
            .newBuilder()
            .addQueryParameter("api-key", apiKey)
            .build()


        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
        return chain.proceed(newRequest)
    }
}
