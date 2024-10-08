package org.example.yugiohkmmtest

import android.app.Application
import org.example.yugiohkmmtest.di.appModule

import org.example.yugiohkmmtest.di.sharedAppModule

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@MainApplication)
            androidLogger()
            modules(appModule(), *sharedAppModule().toTypedArray())
        }

    }
}