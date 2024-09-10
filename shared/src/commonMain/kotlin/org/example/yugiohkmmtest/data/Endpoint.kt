package org.example.yugiohkmmtest.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonBuilder
import kotlinx.serialization.json.JsonConfiguration
import org.example.yugiohkmmtest.domain.DTO.CardDTOResponse

interface Endpoint {
     fun testChannel(): String
    suspend fun getblueDragon(): String
}

class EndpointImp(): Endpoint {
    val client = HttpClient(){
        install(ContentNegotiation) {
            Json{
                isLenient = true
                ignoreUnknownKeys = true
            }
        }
    }

    override fun testChannel(): String {
//        val response: HttpResponse = client.get("https://ktor.io/")
//
//        println(response.status)
        return "HOLA soy paddingtong"
        //client.close()
    }

    override suspend fun getblueDragon(): String {
        val response :String = client.get("https://db.ygoprodeck.com/api/v7/cardinfo.php?archetype=Blue-Eyes").body<String>()?:"Error avisale a luis"
        //INTERNAL CONSTRUCTOR
        val json = Json {ignoreUnknownKeys = true}
        json.configuration.ignoreUnknownKeys
        val obj = json.decodeFromString<CardDTOResponse>(response)
        println(obj.data.get(1))
        return response
    }


}
//
//fun deserializeYugiohCardResponse(response: String): YugiohCardsResponse? {
//    val gson = Gson()
//
//    try {
//        val responseParsed = gson.fromJson(response,YugiohCardsResponse::class.java)
//        println(responseParsed)
//        return responseParsed
//    }catch (e:Exception){
//        return null
//    }
//}