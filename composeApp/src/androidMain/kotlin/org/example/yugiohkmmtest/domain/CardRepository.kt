package org.example.yugiohkmmtest.domain

import org.example.yugiohkmmtest.model.CardsList

interface CardRepository {
    fun getCards(): List<CardsList>
}