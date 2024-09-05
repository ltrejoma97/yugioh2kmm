package org.example.yugiohkmmtest.domain

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetBlueEyesDragonCardsUseCaseHelper : KoinComponent {
    private val useCase : GetBlueEyesDragonCardsUseCase by inject()
    suspend fun callUseCase() : String = useCase.invoke()
}