package org.example.yugiohkmmtest.domain.useCases

import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

interface RealmTestUseCase {
   suspend fun writeTestChannel()
   suspend fun readTestChannel(): String

}

class RealmTestUseCaseImp():RealmTestUseCase{
    val realm by lazy {
        val config = RealmConfiguration.create(setOf(QueryInfo::class))
        Realm.open(config)
    }
    override suspend fun writeTestChannel() {
        val info = QueryInfo().apply {
            _id = "xlg42"
            queries = "Hola soy paddingtong"
        }
        realm.write {
            copyToRealm(info)
        } 
    }

    override suspend fun readTestChannel(): String {
        val response = realm.query(QueryInfo::class)
        return response.first().find()?.queries?: "error raro"

    }

}



class QueryInfo : RealmObject {
    @PrimaryKey
    var _id: String = ""
    var queries: String = ""
}