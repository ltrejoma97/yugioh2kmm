package org.example.yugiohkmmtest.data

import org.example.yugiohkmmtest.model.CardsModel

object CardManager {

    private var currentId = 1

    val fakeCards = mutableListOf(
        CardsModel(
            id = currentId++,
            name = "name1",
            type = "type1",

        ),
        CardsModel(
            id = currentId++,
            name = "name2",
            type = "type2",

        ),
        CardsModel(
            id = currentId++,
            name = "name3",
            type = "type3",

        ),
        CardsModel(
            id = currentId++,
            name = "name4",
            type = "type4",

        ),
        CardsModel(
            id = currentId++,
            name = "name5",
            type = "type5",

        )
    )
}