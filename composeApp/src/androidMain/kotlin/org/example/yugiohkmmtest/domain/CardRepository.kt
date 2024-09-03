package org.example.yugiohkmmtest.domain

import org.example.yugiohkmmtest.model.CardsList

interface CardRepository {
    suspend fun getCards(): List<CardsList>
}