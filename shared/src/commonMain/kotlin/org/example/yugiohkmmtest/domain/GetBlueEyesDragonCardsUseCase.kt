package org.example.yugiohkmmtest.domain

import org.example.yugiohkmmtest.data.Endpoint
import org.example.yugiohkmmtest.domain.DTO.CardDTOResponse


interface GetBlueEyesDragonCardsUseCase {
    @Throws(Exception::class) suspend fun invoke(): CardDTOResponse
    fun testChannel() : String
}

class GetBlueEyesDragonCardsUseCaseImp(val endpoint: Endpoint) : GetBlueEyesDragonCardsUseCase{
    override suspend fun invoke(): CardDTOResponse {
        return endpoint.getblueDragon()
    }

    override fun testChannel(): String {
       return endpoint.testChannel()
    }
}
