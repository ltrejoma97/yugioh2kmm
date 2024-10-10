package org.example.yugiohkmmtest.data

import org.example.yugiohkmmtest.model.CardsModel

object CardManager {

    private var currentId = 1

    val fakeCards = mutableListOf(
        CardsModel(
            id = currentId++,
            name = "name1",
            type = "type1",
            atk = 1,
            def = 1,
            level = 1

        ),
        CardsModel(
            id = currentId++,
            name = "name2",
            type = "type2",
            atk = 2,
            def = 2,
            level = 2

        ),
        CardsModel(
            id = currentId++,
            name = "name3",
            type = "type3",
            atk = 3,
            def = 3,
            level = 3

        ),
        CardsModel(
            id = currentId++,
            name = "name4",
            type = "type4",
            atk = 4,
            def = 4,
            level = 4


        ),
        CardsModel(
            id = currentId++,
            name = "name5",
            type = "type5",
            atk = 5,
            def = 5,
            level = 5

        )
    )
}