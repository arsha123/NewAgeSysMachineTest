package com.example.newagesysmachinetest.utils

import android.app.Activity
import android.content.Intent
import android.os.Bundle

object ActivityUtils {

    fun startActivity(activity: Activity, aClass: Class<*>, bundle: Bundle?, isFinish: Boolean) {
        val intent = Intent(activity, aClass)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        activity.startActivity(intent)
        if (isFinish) {
            activity.finish()
        }
    }

    fun startActivityForResult(activity: Activity, aClass: Class<*>, bundle: Bundle?, isFinish: Boolean, requestCode: Int) {
        val intent = Intent(activity, aClass)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        activity.startActivityForResult(intent, requestCode)
        if (isFinish) {
            activity.finish()
        }
    }
}