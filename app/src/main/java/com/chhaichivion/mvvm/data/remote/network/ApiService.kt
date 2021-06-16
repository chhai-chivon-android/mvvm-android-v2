package com.chhaichivion.mvvm.data.remote.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Copyright (c) PRASAC MFI, Ltd. All rights reserved. (https://www.prasac.com.kh/)
 * Author	: Chhai Chivon (chivon.chhai@prasac.com.kh) on 4/23/21.
 * Position : Senior Application Development Officer
 */
class ApiService {

    private var retrofit: Retrofit? = null

    fun getAPI(): ApiService? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .baseUrl("https://loabe.prasac.com.kh/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
        return retrofit!!.create(ApiService::class.java)
    }
}

