package org.example.yugiohkmmtest.domain

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.yugiohkmmtest.data.Endpoint
import org.example.yugiohkmmtest.domain.DTO.CardDTOResponse


interface GetBlueEyesDragonCardsUseCase {
    @Throws(Exception::class) suspend fun invoke(): CardDTOResponse
    fun testChannel() : String

    fun testFlow() : Flow<String>
}

class GetBlueEyesDragonCardsUseCaseImp(val endpoint: Endpoint) : GetBlueEyesDragonCardsUseCase{
    override suspend fun invoke(): CardDTOResponse {
        return endpoint.getblueDragon()
    }

    override fun testChannel(): String {
       return endpoint.testChannel()
    }

    override fun testFlow(): Flow<String> {
        return flow{
            delay(1000)
            emit("RESULTADO DEL FLOW")
            delay(1000)
            emit("RESULTADO DEL FLOW")
            delay(1000)
            emit("RESULTADO DEL FLOW")
            delay(1000)
            emit("RESULTADO DEL FLOW")
            delay(1000)
            emit("RESULTADO DEL FLOW")
        }
    }
}
