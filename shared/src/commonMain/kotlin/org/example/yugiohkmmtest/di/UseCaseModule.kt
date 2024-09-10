package org.example.yugiohkmmtest.di

import org.example.yugiohkmmtest.domain.GetBlueEyesDragonCardsUseCase
import org.example.yugiohkmmtest.domain.GetBlueEyesDragonCardsUseCaseImp
import org.koin.dsl.module

val useCaseModule = module {

    // Singleton GetYugiohCardsUseCase
    factory <GetBlueEyesDragonCardsUseCase> { GetBlueEyesDragonCardsUseCaseImp(get()) }


}