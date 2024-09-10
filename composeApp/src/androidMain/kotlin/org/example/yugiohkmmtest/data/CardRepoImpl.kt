package org.example.yugiohkmmtest.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import kotlinx.serialization.json.Json
import org.example.yugiohkmmtest.domain.CardRepository
import org.example.yugiohkmmtest.model.CardDTOResponse
import org.example.yugiohkmmtest.model.CardModel

private const val BASE_URL = "https://db.ygoprodeck.com/api/v7/cardinfo.php"

class CardRepoImpl(
    private val cardManager: CardManager,
//    private val httpClient: HttpClient
) : CardRepository {
    override suspend fun getCards(): List<CardModel> {

        val client = HttpClient() {
            install(ContentNegotiation) {
                Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            }
        }

        return try {
            val cartas= client.get(BASE_URL).body<List<CardDTOResponse>>()
            cartas.map {response ->
                CardModel(
                    id = response.id,
                    name = response.name,
                    type = response.type,
                    atk = response.atk,
                    def = response.def

                )

            }
        } catch (e: Exception) {
            emptyList()
        }

//        return cardManager.fakeCards
    }
}