package com.gojek.gojekassignment

import android.app.Application
import com.gojek.gojekassignment.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

/**
 * Created by LaatonWalaBhoot on 11/06/21.
 */
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        setupLogging()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                listOf(
                    viewModelModule
                )
            )
        }
    }

    private fun setupLogging() =
        Timber.plant(Timber.DebugTree())
}