package com.examples.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by teo on 20/5/2018.
 */

class NetworkUtils(private val context: Context) : NUtils {

    /**
     * Checks is we are currently connected to network.
     *
     * @return true if connected, otherwise false.
     */
    @SuppressLint("MissingPermission")
    override fun isConnected(): Boolean {
        val cm = context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo

        return netInfo != null && netInfo.isConnectedOrConnecting
    }

}

interface NUtils {
    fun isConnected() : Boolean
}