package org.example.yugiohkmmtest.data

import org.example.yugiohkmmtest.domain.CardRepository
import org.example.yugiohkmmtest.model.CardsList

class CardRepoImpl(private val cardManager: CardManager): CardRepository {
    override fun getCards(): List<CardsList> {
        return cardManager.fakeCards
    }
}