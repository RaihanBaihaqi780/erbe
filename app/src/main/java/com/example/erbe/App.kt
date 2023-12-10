package com.example.erbe

import android.app.Application
import com.example.erbe.di.networkModule
import com.example.erbe.di.respositoryModule
import com.example.erbe.di.roomModule
import com.example.erbe.di.viewModel

import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE )
            androidContext(this@App)
            modules(
                listOf(
                    networkModule,
                    respositoryModule,
                    roomModule,
                    viewModel
                )

            )
        }
    }
}