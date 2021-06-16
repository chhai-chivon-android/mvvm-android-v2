package com.chhaichivion.mvvm.data.remote.network

import com.chhaichivion.mvvm.data.remote.response.Token
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


/**
 * Copyright (c) PRASAC MFI, Ltd. All rights reserved. (https://www.prasac.com.kh/)
 * Author	: Chhai Chivon (chivon.chhai@prasac.com.kh) on 6/16/21.
 * Position : Senior Application Development Officer
 */
interface TokenApi {

    @FormUrlEncoded
    @POST("oauth/token")
    suspend fun login(@FieldMap login: Map<String, String?>): Token
}