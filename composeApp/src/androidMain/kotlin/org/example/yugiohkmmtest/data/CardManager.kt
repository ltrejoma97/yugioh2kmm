package org.example.yugiohkmmtest.data

import org.example.yugiohkmmtest.model.CardsList

object CardManager {

    private var currentId = 1

    val fakeCards = mutableListOf(
        CardsList(
            id = currentId++,
            name = "name1",
            type = "type1",

        ),
        CardsList(
            id = currentId++,
            name = "name2",
            type = "type2",

        ),
        CardsList(
            id = currentId++,
            name = "name3",
            type = "type3",

        ),
        CardsList(
            id = currentId++,
            name = "name4",
            type = "type4",

        ),
        CardsList(
            id = currentId++,
            name = "name5",
            type = "type5",

        )
    )
}