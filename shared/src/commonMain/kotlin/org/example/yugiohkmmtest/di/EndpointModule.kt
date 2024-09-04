package org.example.yugiohkmmtest.di

import org.example.yugiohkmmtest.data.Endpoint
import org.example.yugiohkmmtest.data.EndpointImp
import org.koin.dsl.module

val endpointModule = module {
    single<Endpoint>{ EndpointImp() }
}