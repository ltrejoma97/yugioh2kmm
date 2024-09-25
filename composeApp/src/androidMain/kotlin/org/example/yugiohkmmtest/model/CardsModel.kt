package org.example.yugiohkmmtest.model

data class CardsModel(
    val data: List<CardsList>
)

data class CardsList(
    val id: Int,
    val name: String,
    val type: String
)