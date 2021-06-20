package com.chhaichivion.mvvm.data.remote.network

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException


/**
 * Copyright (c) PRASAC MFI, Ltd. All rights reserved. (https://www.prasac.com.kh/)
 * Author	: Chhai Chivon (chivon.chhai@prasac.com.kh) on 6/20/21.
 * Position : Senior Application Development Officer
 */
class HeaderInterceptor(context: Context) : Interceptor {

    private val context: Context

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("Language", "km")
            .addHeader("Device", "ANDROID")
            .addHeader("LoanId", "0")
            .build()
        return chain.proceed(request)
    }
    init {
        this.context = context
    }
}