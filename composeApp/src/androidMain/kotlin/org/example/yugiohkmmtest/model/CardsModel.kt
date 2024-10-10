package org.example.yugiohkmmtest.model

import kotlinx.serialization.Serializable


@Serializable
data class CardsModel(
    val id: Int,
    val name: String,
    val type: String,
    val atk: Int,
    val def: Int,
    val level: Int
)