package com.chhaichivion.mvvm.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chhaichivion.mvvm.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


    }

    fun asMap() = hashMapOf(
        "grant_type" to "",
        "client_id" to "",
        "client_secret" to "",
        "username" to "",
        "password" to "",
        "isForceLogin" to "true",
        "latitude" to "",
        "longitude" to "",
        "macAddress" to "",
        "device" to "ANDROID",
        "deviceName" to ""
    )
}