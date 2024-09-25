package org.example.yugiohkmmtest.domain




import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import org.example.yugiohkmmtest.data.repository.CardsRepository
import org.example.yugiohkmmtest.domain.modelObjexts.YugiohCard
import org.example.yugiohkmmtest.domain.modelObjexts.mapToUiListCard
import org.example.yugiohkmmtest.domain.useCases.BaseResponse
import org.example.yugiohkmmtest.domain.useCases.GeneralError
import org.example.yugiohkmmtest.domain.useCases.UseCaseResponse



interface GetBlueEyesDragonCardsUseCase {
    @Throws(Exception::class) suspend fun invoke(): UseCaseResponse<List<YugiohCard>>
    fun testChannel() : String

    fun testFlow() : Flow<String>
}

class GetBlueEyesDragonCardsUseCaseImp(val repository: CardsRepository) : GetBlueEyesDragonCardsUseCase{
    override suspend fun invoke(): UseCaseResponse<List<YugiohCard>> {
        try {
            val response =  repository.getBlueEyesCards()
            val cardList : List<YugiohCard> = response.mapToUiListCard()
            return UseCaseResponse.success(cardList)
        }catch (e:Exception){
            return UseCaseResponse.error(GeneralError.KnownError(e.message.toString()))
        }
    }

    override fun testChannel(): String {
//       return endpoint.testChannel()
        return "Test 18/09/2024"
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




