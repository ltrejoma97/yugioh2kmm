package org.example.yugiohkmmtest.data.LocalDataSource

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.example.yugiohkmmtest.data.TypeOfCard
import org.example.yugiohkmmtest.domain.DTO.CardImages
import org.example.yugiohkmmtest.domain.DTO.CardPrices
import org.example.yugiohkmmtest.domain.modelObjexts.YugiohCard

const val SPELL_CARD = "Spell"
const val MONSTER_CARD = "Monster"
const val TRAP_CARD = "Trap"

class DatabaseCard: RealmObject {
    @PrimaryKey
    var id :Int=0
    var name : String=""
    var humanReadableName : String= ""
    var desc :String=""
    var race : String = ""
    var ygoprodeck_url : String =""
    var archetype : String = ""
    var atk : Int =0
    var def : Int = 0
    var frameType: String=""
    var level : Int = 0
    var attribute : String = ""
    var imgUrl : String=""
    var imgUrlSmall : String = ""


    fun mapToYugiohCard(): YugiohCard {
        return YugiohCard(id, name, getFrameType(humanReadableName), desc, race, ygoprodeck_url, archetype, atk,def, frameType, level, attribute, imgUrl, imgUrlSmall)
    }

    fun getFrameType(humanReadable: String): TypeOfCard {
        if (humanReadable.contains(MONSTER_CARD))
            return TypeOfCard.Monster
        else if (humanReadable.contains(TRAP_CARD))
            return TypeOfCard.Trap
        else
            return TypeOfCard.Spell

    }
}




