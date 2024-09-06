package org.example.yugiohkmmtest.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import kotlinx.serialization.json.Json
import org.example.yugiohkmmtest.domain.CardRepository
import org.example.yugiohkmmtest.model.CardsList

private const val BASE_URL = "https://db.ygoprodeck.com/api/v7/cardinfo.php"
class CardRepoImpl(
    private val cardManager: CardManager,
//    private val httpClient: HttpClient
    ): CardRepository {
    override suspend fun getCards(): String {

        val client = HttpClient(){
            install(ContentNegotiation) {
                Json{
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            }
        }

        return try {
            val cartas :String = client.get(BASE_URL).body<String>()
             cartas
        }catch (e:Exception){
             "ERROR"
        }

//        return cardManager.fakeCards
    }
}