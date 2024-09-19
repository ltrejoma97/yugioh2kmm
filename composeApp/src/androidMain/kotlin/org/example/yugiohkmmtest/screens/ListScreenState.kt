package org.example.yugiohkmmtest.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.yugiohkmmtest.R
import org.example.yugiohkmmtest.model.CardsList
import org.example.yugiohkmmtest.viewModel.CardsUiState
import org.example.yugiohkmmtest.viewModel.ListScreenViewModel
import org.koin.androidx.compose.get

@Composable
fun ListScreenState(uiState: CardsUiState) {
    //val listScreenViewModel : ListScreenViewModel = ListScreenViewModel(get())
    //listScreenViewModel.getAllCards()
    LazyColumn {
        //item { Text(text = listScreenViewModel.uiState.responseCards) }
        items(uiState.cardsList) {
            CardElemento(cardItem = it)
        }
    }
}



@Composable
fun CardElemento(cardItem: CardsList) {
    Card(modifier = Modifier
        .padding(16.dp)
        .clickable { }, elevation = 8.dp) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            androidx.compose.material3.Text(text = cardItem.name, fontSize = 20.sp)
            Image(
                painter = painterResource(id = R.drawable.mago),
                contentDescription = "picture",
                contentScale = androidx.compose.ui.layout.ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .size(330.dp)

            )
        }
    }
}