package org.example.yugiohkmmtest.model

import kotlinx.serialization.Serializable

//data class CardsModel(
//    val data: List<CardModel>
//)

data class CardModel(
    val id: Int,
    val name: String,
    val type: String,
    val atk: String,
    val def: String
)

@Serializable
data class CardDTOResponse(
    val data: List<CardDto>,
)


@Serializable
data class CardDto(
    val id :Int,
    val name : String,
    val type : String,
    val desc :String,
    val race : String="",
    val ygoprodeck_url : String,
    val archetype : String,
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


fun CardDTOResponse.toModel() = CardModel(
    id = data[0].id,
    name = data[0].name,
    type = data[0].type,
    atk = data[0].atk.toString(),
    def = data[0].def.toString()
)