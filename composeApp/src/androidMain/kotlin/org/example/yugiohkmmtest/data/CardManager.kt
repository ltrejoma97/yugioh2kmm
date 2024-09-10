package org.example.yugiohkmmtest.data

import org.example.yugiohkmmtest.model.CardModel

object CardManager {

    private var currentId = 1

    val fakeCards = mutableListOf(
        CardModel(
            id = currentId++,
            name = "name1",
            type = "type1",
            atk = "atk1",
            def = "def1"
        ),
        CardModel(
            id = currentId++,
            name = "name2",
            type = "type2",
            atk = "atk2",
            def = "def2"
        ),
        CardModel(
            id = currentId++,
            name = "name3",
            type = "type3",
            atk = "atk3",
            def = "def3"
        ),
        CardModel(
            id = currentId++,
            name = "name4",
            type = "type4",
            atk = "atk4",
            def = "def4"
        ),
        CardModel(
            id = currentId++,
            name = "name5",
            type = "type5",
            atk = "atk5",
            def = "def5"
        )
    )
}