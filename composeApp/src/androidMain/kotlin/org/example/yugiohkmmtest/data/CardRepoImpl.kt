package org.example.yugiohkmmtest.data

import io.ktor.client.HttpClient
import org.example.yugiohkmmtest.domain.CardRepository
import org.example.yugiohkmmtest.model.CardsList

private const val BASE_URL = "https://db.ygoprodeck.com/api/v7/cardinfo.php"
class CardRepoImpl(
    private val cardManager: CardManager,
//    private val httpClient: HttpClient
    ): CardRepository {
    override suspend fun getCards(): List<CardsList> {
        return cardManager.fakeCards
    }
}