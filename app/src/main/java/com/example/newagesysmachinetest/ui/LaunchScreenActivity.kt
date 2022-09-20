package com.example.newagesysmachinetest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.newagesysmachinetest.R
import com.example.newagesysmachinetest.utils.ActivityUtils

class LaunchScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_screen)
        Handler(Looper.getMainLooper()).postDelayed({


            ActivityUtils.startActivity(
                this@LaunchScreenActivity,
                HomeActivity::class.java,
                null,
                true
            )
        }, 3000)
    }
}