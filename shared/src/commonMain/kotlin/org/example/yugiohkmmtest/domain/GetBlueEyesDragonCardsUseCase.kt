package org.example.yugiohkmmtest.domain

import org.example.yugiohkmmtest.data.Endpoint
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


interface GetBlueEyesDragonCardsUseCase {
    suspend fun invoke(): String
}

class GetBlueEyesDragonCardsUseCaseImp(val endpoint: Endpoint) : GetBlueEyesDragonCardsUseCase{
    override suspend fun invoke(): String {
        return endpoint.getblueDragon()
    }
}

class GetBlueEyesDragonCardsUseCaseHelper : KoinComponent {
    private val useCase : GetBlueEyesDragonCardsUseCase by inject()
    suspend fun callUseCase() : String = useCase.invoke()
}