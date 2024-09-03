package org.example.yugiohkmmtest.di

import org.koin.core.module.dsl.createdAtStart
import org.koin.core.module.dsl.withOptions
import org.koin.dsl.module
import org.example.yugiohkmmtest.data.CardManager
import org.example.yugiohkmmtest.data.CardRepoImpl
import org.example.yugiohkmmtest.domain.CardRepository
import org.example.yugiohkmmtest.viewModel.MainViewModel

fun appModule() = module {
    single { CardManager }.withOptions { createdAtStart() }
    single<CardRepository> { CardRepoImpl(get()) }
    factory { MainViewModel(get()) }
}