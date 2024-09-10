package org.example.yugiohkmmtest.domain

import org.example.yugiohkmmtest.domain.DTO.CardDTOResponse
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetBlueEyesDragonCardsUseCaseHelper : KoinComponent {
    private val useCase : GetBlueEyesDragonCardsUseCase by inject()
    suspend fun callUseCase() : String = useCase.invoke()
    fun testChannel(): String = useCase.testChannel()
}