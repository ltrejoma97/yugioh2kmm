package org.example.yugiohkmmtest.model

import kotlinx.serialization.Serializable


@Serializable
data class CardsModel(
    val id: Int,
    val name: String,
    val type: String
)