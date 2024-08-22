package org.example.yugiohkmmtest.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun ListScreen() {
    val cards: List<CardsList> = listOf(
        CardsList(1, "name1", "type1", "atk1", "def1"),
        CardsList(2, "name2", "type2", "atk2", "def2"),
        CardsList(3, "name3", "type3", "atk3", "def3")
    )
    LazyColumn{
        items(cards) { card ->
            Text(text = card.name)
        }
    }
}

data class CardsList(
    val id: Int,
    val name: String,
    val type: String,
    val atk: String,
    val def: String
)