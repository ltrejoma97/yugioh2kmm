package org.example.yugiohkmmtest.data.LocalDataSource

import io.realm.kotlin.types.RealmObject
import org.example.yugiohkmmtest.data.TypeOfCard
import org.example.yugiohkmmtest.domain.DTO.CardImages
import org.example.yugiohkmmtest.domain.DTO.CardPrices

//class DatabaseCard(
//     var id :Int,
//     val name : Int,
//     val type : String,
//     val desc :String,
//     val race : String = "",
//     val ygoprodeck_url : String,
//     val archetype : String,
//     val humanReadableCardType : String,
//     val atk : Int =0 ,
//     val def : Int = 0,
//     val frameType: String,
//     val level : Int = 0,
//     val attribute : String = "",
//     val card_images: List<CardImages>,
//     val card_prices: List<CardPrices>): RealmObject {
//
////     fun getTypeOfCard(): TypeOfCard {
////          when (this.humanReadableCardType){
////
////               return TypeOfCard.Spell
////
////          }
////     }
//
//}
const val SPELL_CARD = "spell"
const val MONSTER_CARD = "monster"
const val TRAP_CARD = "trao"