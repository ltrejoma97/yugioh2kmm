package org.example.yugiohkmmtest.domain.modelObjexts

import kotlinx.serialization.Serializable
import org.example.yugiohkmmtest.data.LocalDataSource.DatabaseCard
import org.example.yugiohkmmtest.data.TypeOfCard



@Serializable
data class YugiohCard(
    val id :Int=0,
    val name : String="",
    val type : TypeOfCard = TypeOfCard.Monster,
    val desc :String="",
    val race : String = "",
    val ygoprodeck_url : String ="",
    val archetype : String = "",
    val atk : Int =0,
    val def : Int = 0,
    val frameType: String="",
    val level : Int = 0,
    val attribute : String = "",
    val imgUrl : String="",
    val imgUrlSmall : String = "")


 fun List<DatabaseCard>.mapToUiListCard(): List<YugiohCard> {
    val cardsUI : MutableList<YugiohCard> = mutableListOf()
    this.forEach {
        try {
            cardsUI.add(it.mapToYugiohCard())
        }catch (e:Exception){
            //go next
        }

    }
    return cardsUI
}