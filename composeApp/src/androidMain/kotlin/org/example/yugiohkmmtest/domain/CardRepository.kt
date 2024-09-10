package org.example.yugiohkmmtest.domain

import org.example.yugiohkmmtest.model.CardDTOResponse
import org.example.yugiohkmmtest.model.CardDto
import org.example.yugiohkmmtest.model.CardModel

//Definir los metodos que se utilizan en el repositorio para acceder a ciertos datos.
interface CardRepository {
    suspend fun getCards(): List<CardModel>
}