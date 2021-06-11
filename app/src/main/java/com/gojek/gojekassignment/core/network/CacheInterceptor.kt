package com.gojek.gojekassignment.core.network

import android.content.Context
import com.gojek.gojekassignment.core.helpers.NetworkHelper
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by LaatonWalaBhoot on 11/06/21.
 */

class CacheInterceptor(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        // Get the request from the chain.
        var request = chain.request()

        /*
        *  Leveraging the advantage of using Kotlin,
        *  we initialize the request and change its header depending on whether
        *  the device is connected to Internet or not.
        */
        request = if (NetworkHelper.isOnline(context)) {
            /*
            *  If there is Internet, get the cache that was stored 5 seconds ago.
            *  If the cache is older than 5 seconds, then discard it,
            *  and indicate an error in fetching the response.
            *  The 'max-age' attribute is responsible for this behavior.
            */

            request.newBuilder().build()
        } else
        /*
        *  If there is no Internet, get the cache that was stored 2 hours ago.
        *  If the cache is older than 2 hours, then discard it.
        *  The 'max-stale' attribute is responsible for this behavior.
        *  The 'only-if-cached' attribute indicates to not retrieve new data; fetch the cache only instead.
        */
            request.newBuilder().header(
                "Cache-Control",
                "public, only-if-cached, max-stale=" + 60 * 60 * 2
            ).build()

        return chain.proceed(request)
    }

}