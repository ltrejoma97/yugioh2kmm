package org.example.yugiohkmmtest.di

import org.example.yugiohkmmtest.data.Endpoint
import org.example.yugiohkmmtest.data.EndpointImp
import org.example.yugiohkmmtest.data.LocalDataSource.RealmDatabase
import org.example.yugiohkmmtest.data.LocalDataSource.RealmDatabaseImp
import org.example.yugiohkmmtest.data.repository.CardsRepository
import org.example.yugiohkmmtest.data.repository.CardsRepositoryImp
import org.koin.dsl.module

val repositoryModule = module {
    single<CardsRepository>{ CardsRepositoryImp(get(),get()) }
    single<RealmDatabase> { RealmDatabaseImp() }
}