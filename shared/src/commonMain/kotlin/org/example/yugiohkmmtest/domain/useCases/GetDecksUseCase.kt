package org.example.yugiohkmmtest.domain.useCases

import kotlinx.coroutines.flow.Flow
import org.example.yugiohkmmtest.data.LocalDataSource.DatabaseCard
import org.example.yugiohkmmtest.data.repository.CardsRepository
import org.example.yugiohkmmtest.domain.modelObjexts.YugiohCard

interface GetClassicCardsUseCase{
    suspend fun invoke(): Flow<List<YugiohCard>>
}
class GetClassicCardsUseCaseImp(private val repository : CardsRepository):GetClassicCardsUseCase{
    override suspend fun invoke(): Flow<List<YugiohCard>> {
        return repository.getClassicCards()
    }

}