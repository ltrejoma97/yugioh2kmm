package org.example.yugiohkmmtest.domain

import org.example.yugiohkmmtest.data.Endpoint


interface GetBlueEyesDragonCardsUseCase {
    suspend fun invoke(): String
}

class GetBlueEyesDragonCardsUseCaseImp(val endpoint: Endpoint) : GetBlueEyesDragonCardsUseCase{
    override suspend fun invoke(): String {
        return endpoint.getblueDragon()
    }
}