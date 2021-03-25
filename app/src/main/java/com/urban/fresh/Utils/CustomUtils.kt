package com.urban.fresh.Utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.widget.Toast

fun Context.isNetworkAvailable(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    @Suppress("DEPRECATION")
    if (connectivityManager.activeNetworkInfo == null || connectivityManager.activeNetworkInfo!!.state == null) {
        return false
    } else {
        val state = connectivityManager.activeNetworkInfo!!.state
        return (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)
    }
}

fun Context.toast(message: CharSequence?) {
    if (message != null) {
        val toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
        toast.show()
    }
}