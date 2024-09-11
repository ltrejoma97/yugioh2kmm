package org.example.yugiohkmmtest.data

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import kotlinx.serialization.json.Json
import org.example.yugiohkmmtest.domain.CardRepository
import org.example.yugiohkmmtest.model.CardDTOResponse

import org.example.yugiohkmmtest.model.CardDto
import org.example.yugiohkmmtest.model.CardModel

private const val BASE_URL = "https://db.ygoprodeck.com/api/v7/cardinfo.php"

class CardRepoImpl(
    private val cardManager: CardManager,
//    private val httpClient: HttpClient
) : CardRepository {
    override suspend fun getCards(): List<CardModel> {

//usas el cliente HttpClient de Ktor para hacer la solicitud a la API
// y obtener los datos de las cartas.
        val client = HttpClient() {
///Usas el plugin ContentNegotiation para deserializar la respuesta JSON en un objeto CardDTOResponse
            install(ContentNegotiation) {
                Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            }
        }

        return try {
//En caso de éxito, mapeas los objetos CardDto a CardModel para usarlos en la UI.
            val cartas= client.get(BASE_URL).body<CardDTOResponse>()
            println(cartas) // Agrega este log para ver si estás recibiendo los datos correctamente
            cartas.data.map { cardDto ->
                cardDto.toModel()
            }
        } catch (e: Exception) {
            Log.e("CardRepoImpl", "Error al obtener las cartas: ${e.message}")
            println("Error: ${e.message}") // Para ver el error si ocurre
            emptyList()
        }

//        return cardManager.fakeCards
    }
    fun CardDto.toModel(): CardModel {
        return CardModel(
            id = this.id,
            name = this.name,
            type = this.type,
            atk = this.atk.toString(),
            def = this.def.toString()
        )
    }

}