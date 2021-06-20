package com.chhaichivion.mvvm.data.remote.network

import com.chhaichivion.mvvm.data.remote.response.AuthRes
import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


/**
 * Copyright (c) PRASAC MFI, Ltd. All rights reserved. (https://www.prasac.com.kh/)
 * Author	: Chhai Chivon (chivon.chhai@prasac.com.kh) on 6/20/21.
 * Position : Senior Application Development Officer
 */
interface AuthApi {

    @FormUrlEncoded
    @POST("oauth/token")
    fun login(@FieldMap login: Map<String, String?>): Call<AuthRes?>?
}