package org.example.yugiohkmmtest.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonBuilder
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.json.encodeToJsonElement
import org.example.yugiohkmmtest.domain.DTO.CardDTOResponse


interface Endpoint {
     fun testChannel(): String
    suspend fun getblueDragon(): CardDTOResponse
    suspend fun getClassicCards():CardDTOResponse

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
    val json = Json {ignoreUnknownKeys = true}

    override fun testChannel(): String {
//        val response: HttpResponse = client.get("https://ktor.io/")
//
//        println(response.status)
        return "HOLA soy paddingtong"
        //client.close()
    }

    override suspend fun getblueDragon(): CardDTOResponse {
        kotlin.runCatching {
            val response :String = client.get("https://db.ygoprodeck.com/api/v7/cardinfo.php?archetype=Blue-Eyes").body<String>()?:"Error avisale a luis"
            //INTERNAL CONSTRUCTOR

            val obj = json.decodeFromString<CardDTOResponse>(response)

            return obj
        }.getOrElse {
           throw it
        }
    }
    // this is  an example using parameters and urls
    override suspend fun getClassicCards(): CardDTOResponse {
        kotlin.runCatching {
            val response = client.get{
                url("https://db.ygoprodeck.com/api/v7/cardinfo.php")
                parameter("startdate","2000-01-01")
                parameter("enddate","2002-08-23")
                parameter("dateregion","tcg")
            }.body<String>()?:"Error con las nuevas cartas avisale a luis "
            val obj = json.decodeFromString<CardDTOResponse>(response)
            return obj

        }.getOrElse {
            throw it
        }
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