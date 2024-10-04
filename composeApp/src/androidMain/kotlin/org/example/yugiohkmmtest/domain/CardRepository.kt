package org.example.yugiohkmmtest.domain

interface CardRepository {
    suspend fun getCards(): String
}