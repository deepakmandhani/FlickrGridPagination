package com.example.flickrsimulation.common

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.view.inputmethod.InputMethodManager

object Utils {

    const val FLICKR_PHOTO_URL = "http://farmKEY1.static.flickr.com/KEY2/KEY3_KEY4.jpg"
    const val COLUMN_NO = 3
    const val REFRESH_BEFORE_LAST = 10

    fun hideKeyboard(activity: Activity) {
        try {
            val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            val ib = activity.currentFocus?.windowToken
            imm.hideSoftInputFromWindow(ib, 0)
        } catch (e: Exception) {
        }
    }

    fun isInternetConnected(context: Context?): Boolean =
        context?.let {
            try {
                val cm =
                    context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                return@let cm.activeNetworkInfo?.isConnectedOrConnecting ?: false
            } catch (e: Exception) {
                return@let false
            }
        } ?: false
}