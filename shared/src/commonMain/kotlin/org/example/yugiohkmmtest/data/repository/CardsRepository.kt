package org.example.yugiohkmmtest.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.yugiohkmmtest.data.Endpoint
import org.example.yugiohkmmtest.data.LocalDataSource.DatabaseCard
import org.example.yugiohkmmtest.data.LocalDataSource.RealmDatabase
import org.example.yugiohkmmtest.domain.DTO.CardDTOResponse
import org.example.yugiohkmmtest.domain.modelObjexts.YugiohCard
import org.example.yugiohkmmtest.domain.modelObjexts.mapToUiListCard

interface CardsRepository {
    suspend fun getBlueEyesCards(): List<DatabaseCard>
    suspend fun getClassicCards(): Flow<List<YugiohCard>>
}

class CardsRepositoryImp(val endpoint: Endpoint, val realmDatabase: RealmDatabase) : CardsRepository{

    override suspend fun getBlueEyesCards(): List<DatabaseCard> {
//        return flow {
//            val cachedCards = realmDatabase.readCards()
//            emit(cachedCards)
//            val response = endpoint.getblueDragon()
//            realmDatabase.saveCards(response)
//            val newResponse = realmDatabase.readCards()
//            emit(newResponse)
//        }

        kotlin.runCatching {
            val response = endpoint.getClassicCards()
            realmDatabase.saveCards(response)
            val newData = realmDatabase.readCards()

            return newData
        }.getOrElse {
            return realmDatabase.readCards()
        }

    }

    override suspend fun getClassicCards(): Flow<List<YugiohCard>> {

        return flow {
            val cachedCards = realmDatabase.readCards()
            emit(cachedCards.mapToUiListCard())
            val response = endpoint.getClassicCards()
            realmDatabase.saveCards(response)
            val newResponse = realmDatabase.readCards().mapToUiListCard()
            emit(newResponse)
        }
    }
}