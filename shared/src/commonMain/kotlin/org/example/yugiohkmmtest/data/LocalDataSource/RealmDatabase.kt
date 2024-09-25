package org.example.yugiohkmmtest.data.LocalDataSource

import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.query.RealmResults
import org.example.yugiohkmmtest.domain.DTO.CardDTOResponse
import org.example.yugiohkmmtest.domain.useCases.QueryInfo

interface RealmDatabase {
   suspend fun saveCards(cardDTOResponse: CardDTOResponse)
   suspend fun readCards(): List<DatabaseCard>
}

class RealmDatabaseImp(): RealmDatabase{

   val realm by lazy {
      val config = RealmConfiguration.create(setOf(QueryInfo::class,DatabaseCard::class))
      Realm.open(config)
   }

   override suspend fun saveCards(cardDTOResponse: CardDTOResponse) {
       kotlin.runCatching {
           val databaseCardMapped = cardDTOResponse.convertTheDataToDatabaseModel()
           realm.write {
               databaseCardMapped.forEach {
                   copyToRealm(it, updatePolicy = UpdatePolicy.ALL)
               }
           }
       }.getOrElse {
           throw it
       }
   }

    override suspend fun readCards(): List<DatabaseCard> {
        kotlin.runCatching {
            return realm.query(DatabaseCard::class).find().toList()

        }.getOrElse {
            throw it
        }
    }


}

