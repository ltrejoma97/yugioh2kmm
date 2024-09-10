package org.example.yugiohkmmtest.domain

import org.example.yugiohkmmtest.data.Endpoint
import org.example.yugiohkmmtest.domain.DTO.CardDTOResponse


interface GetBlueEyesDragonCardsUseCase {
    suspend fun invoke(): String
    fun testChannel() : String
}

class GetBlueEyesDragonCardsUseCaseImp(val endpoint: Endpoint) : GetBlueEyesDragonCardsUseCase{
    override suspend fun invoke(): String {
        return endpoint.getblueDragon()
    }

    override fun testChannel(): String {
       return endpoint.testChannel()
    }
}
