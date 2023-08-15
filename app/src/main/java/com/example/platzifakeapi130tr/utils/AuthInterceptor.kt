package com.example.platzifakeapi130tr.utils

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject


//s24
class AuthInterceptor @Inject constructor(private var prefManager: PrefManager) : Interceptor{

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request().newBuilder()
        request.addHeader("Authorization", "Bearer ${prefManager.getPref(KEY_ACCESS_TOKEN)}")

        return chain.proceed(request.build())

    }


}