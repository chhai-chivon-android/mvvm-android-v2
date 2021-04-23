package com.chhaichivion.mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chhaichivion.mvvm.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //https://github.com/IsaiasCuvula/weather_app

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvUser.text = "Hello World2"
    }
}