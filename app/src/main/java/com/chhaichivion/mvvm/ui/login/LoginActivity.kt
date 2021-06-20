package com.chhaichivion.mvvm.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.chhaichivion.mvvm.R
import com.chhaichivion.mvvm.data.remote.network.ApiService
import com.chhaichivion.mvvm.data.remote.network.AuthApi
import com.chhaichivion.mvvm.data.remote.response.AuthRes
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val request: AuthApi = ApiService().getInstance(applicationContext)!!.create(AuthApi::class.java)
        val call: Call<AuthRes?>? = request.login(loginPayload())
        call?.enqueue(object : Callback<AuthRes?> {
            override fun onResponse(call: Call<AuthRes?>, response: Response<AuthRes?>) {
                val authRes: AuthRes? = response.body()
                Log.d("Data", Gson().toJson(authRes))
                //mLoginListener.onSuccess(response.message(), authRes)
            }

            override fun onFailure(call: Call<AuthRes?>, t: Throwable) {
                Log.v("Error ", t.message!!)
                //mLoginListener.onFailure(t.message)
            }
        })
    }

    fun loginPayload() = hashMapOf(
        "grant_type" to "password",
        "client_id" to "LOA_CLIENT_ID",
        "client_secret" to "LOA_CLIENT_SECRET",
        "username" to "chivon.chhai",
        "password" to "\$Hello123",
        "isForceLogin" to "true",
        "latitude" to "0.3432",
        "longitude" to "0.3432",
        "macAddress" to "vjvjd24222",
        "device" to "ANDROID",
        "deviceName" to "Chivon-Android"
    )
}