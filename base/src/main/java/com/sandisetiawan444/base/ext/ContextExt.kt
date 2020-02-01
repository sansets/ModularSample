package com.sandisetiawan444.base.ext

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast

/**
 * Created by Sandi on 01/02/2020.
 */

fun Context.navigatorImplicit(
    activityPackage: String,
    className: String,
    extras: Bundle = Bundle(),
    option: Bundle? = null
) {
    val intent = Intent()
    try {
        intent.setClassName(activityPackage, className).putExtras(extras)

        if (option != null) {
            startActivity(intent, option)
        } else {
            startActivity(intent)
        }
    } catch (e: Exception) {
        Toast.makeText(this, "Activity not found", Toast.LENGTH_SHORT).show()
        e.printStackTrace()
    }
}