package org.example.yugiohkmmtest.domain.DTO

import io.ktor.websocket.FrameType
import kotlinx.serialization.Serializable
import org.example.yugiohkmmtest.data.LocalDataSource.DatabaseCard
import org.example.yugiohkmmtest.data.LocalDataSource.MONSTER_CARD
import org.example.yugiohkmmtest.data.LocalDataSource.TRAP_CARD
import org.example.yugiohkmmtest.data.TypeOfCard


@Serializable
data class CardDTOResponse(
    val data: List<CardDto> = listOf() ,
    val error : String="", ){

    fun convertTheDataToDatabaseModel(): Array<DatabaseCard> {
        kotlin.runCatching {
            if (data.isNotEmpty()){
                val databaseElements :MutableList<DatabaseCard> = mutableListOf()
                this.data.forEach {
                    val mappedToDatabase = DatabaseCard().apply {
                        id = it.id
                        name = it.name
                        humanReadableName = it.humanReadableCardType
                        desc = it.desc
                        race = it.race
                        ygoprodeck_url = it.ygoprodeck_url
                        archetype = it.archetype
                        atk = it.atk
                        def = it.def
                        frameType = it.frameType
                        level = it.level
                        attribute = it.attribute
                        imgUrl = it.card_images.first().image_url
                        imgUrlSmall = it.card_images.first().image_url_small
                    }
                    databaseElements.add(mappedToDatabase)
                }
                return databaseElements.toTypedArray()
            }
            return emptyArray()
        }.getOrElse { throw it }

    }


}


@Serializable
data class CardDto(
    val id :Int,
    val name : String,
    val type : String,
    val desc :String,
    val race : String="",
    val ygoprodeck_url : String,
    val archetype : String,
    val frameType: String,
    val humanReadableCardType : String,
    val atk : Int=0,
    val def : Int=0,
    val level : Int=0,
    val attribute : String="",
    val card_images: List<CardImages>,
    val card_prices: List<CardPrices>
)
@Serializable
data class CardImages(
    val id: Int,
    val image_url: String,
    val image_url_small: String,
    val image_url_cropped: String,

)
@Serializable
data class CardPrices (
    val cardmarket_price: Double,
    val tcgplayer_price: Double,
    val ebay_price: Double,
    val amazon_price: Double,
    val coolstuffinc_price: Double
)
