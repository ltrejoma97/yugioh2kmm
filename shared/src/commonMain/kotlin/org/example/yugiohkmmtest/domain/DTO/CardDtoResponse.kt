package org.example.yugiohkmmtest.domain.DTO

import io.ktor.websocket.FrameType
import kotlinx.serialization.Serializable


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
