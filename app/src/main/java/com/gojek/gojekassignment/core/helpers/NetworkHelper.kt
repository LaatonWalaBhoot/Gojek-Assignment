package com.gojek.gojekassignment.core.helpers

import android.content.Context
import android.net.ConnectivityManager
import android.telephony.TelephonyManager
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by LaatonWalaBhoot on 11/06/21.
 */

object NetworkHelper {

    fun isOnline(context: Context): Boolean {
        return try {
            val cm =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfoMobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
            val netInfoWifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
            netInfoMobile != null && netInfoMobile.isConnectedOrConnecting ||
                    netInfoWifi != null && netInfoWifi.isConnectedOrConnecting
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}