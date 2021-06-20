package com.chhaichivion.mvvm.data.remote.network

import android.content.Context
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

/**
 * Copyright (c) PRASAC MFI, Ltd. All rights reserved. (https://www.prasac.com.kh/)
 * Author	: Chhai Chivon (chivon.chhai@prasac.com.kh) on 4/23/21.
 * Position : Senior Application Development Officer
 */
class ApiService {

    val BASE_URL = "https://loabe.prasac.com.kh/"
    private var sInstance: Retrofit? = null
    private val context: Context? = null

    fun getInstance(context: Context): Retrofit? {
        val gson = GsonBuilder()
                .setLenient()
                .create()
        if (sInstance == null) {
            sInstance = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClientBuilder(context))
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
        }
        return sInstance
    }

    fun okHttpClientBuilder(context: Context) : OkHttpClient {
        val builder = OkHttpClient.Builder()
        try {
            val trustAllCerts: Array<TrustManager> = arrayOf(
                    object : X509TrustManager {

                        @Throws(CertificateException::class)
                        override fun checkClientTrusted(
                                chain: Array<X509Certificate?>?,
                                authType: String?
                        ) {
                        }

                        override fun checkServerTrusted(
                                chain: Array<X509Certificate?>?,
                                authType: String?
                        ) {
                        }

                        override fun getAcceptedIssuers(): Array<X509Certificate> {
                            return arrayOf()
                        }
                    }
            )

            val sslContext: SSLContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, SecureRandom())
            val sslSocketFactory: SSLSocketFactory = sslContext.socketFactory
            builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)

            builder.addInterceptor(HeaderInterceptor(context))
            httpLoggingInterceptor()?.let { builder.addInterceptor(it) }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return builder.build()
    }

    private fun httpLoggingInterceptor(): HttpLoggingInterceptor? {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS)
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return logging
    }
}

