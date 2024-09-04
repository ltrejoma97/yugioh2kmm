package org.example.yugiohkmmtest.di

import org.koin.core.context.startKoin

fun initKoin(){
    startKoin {
        modules(sharedAppModule())
    }
}