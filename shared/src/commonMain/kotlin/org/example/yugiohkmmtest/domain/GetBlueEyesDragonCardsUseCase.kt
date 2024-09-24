package org.example.yugiohkmmtest.domain



import org.example.yugiohkmmtest.data.repository.CardsRepository
import org.example.yugiohkmmtest.domain.modelObjexts.YugiohCard
import org.example.yugiohkmmtest.domain.modelObjexts.mapToUiListCard
import org.example.yugiohkmmtest.domain.useCases.BaseUseCaseResponse


interface GetBlueEyesDragonCardsUseCase {
    @Throws(Exception::class) suspend fun invoke(): BaseUseCaseResponse<List<YugiohCard>>
    fun testChannel() : String
}

class GetBlueEyesDragonCardsUseCaseImp(val repository: CardsRepository) : GetBlueEyesDragonCardsUseCase{
    override suspend fun invoke(): BaseUseCaseResponse<List<YugiohCard>> {
        try {
            val response =  repository.getBlueEyesCards()
            val cardList : List<YugiohCard> = response.mapToUiListCard()
            return BaseUseCaseResponse.Success(cardList)
        }catch (e:Exception){
            return BaseUseCaseResponse.Error(e.message.toString())
        }
    }

    override fun testChannel(): String {
//       return endpoint.testChannel()
        return "Test 18/09/2024"
    }


}




