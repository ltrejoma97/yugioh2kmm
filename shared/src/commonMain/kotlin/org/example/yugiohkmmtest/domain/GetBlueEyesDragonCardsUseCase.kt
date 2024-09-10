package org.example.yugiohkmmtest.domain

import org.example.yugiohkmmtest.data.Endpoint
import org.example.yugiohkmmtest.domain.DTO.CardDTOResponse


interface GetBlueEyesDragonCardsUseCase {
    suspend fun invoke(): CardDTOResponse
}

class GetBlueEyesDragonCardsUseCaseImp(val endpoint: Endpoint) : GetBlueEyesDragonCardsUseCase{
    override suspend fun invoke(): CardDTOResponse {
        return endpoint.getblueDragon()
    }
}
