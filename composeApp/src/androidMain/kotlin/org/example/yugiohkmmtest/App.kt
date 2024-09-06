package org.example.yugiohkmmtest

import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import org.example.yugiohkmmtest.screens.MainScreen
import org.example.yugiohkmmtest.viewModel.ListScreenViewModel
import org.example.yugiohkmmtest.viewModel.MainViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.androidx.compose.get

@Composable
@Preview
fun App() {

    MaterialTheme {


        PreComposeApp {
            val viewModel = MainViewModel(get(), get())



//
//            val viewModel = viewModel(modelClass = MainViewModel::class) {
//              MainViewModel(CardRepoImpl(CardManager))
//            }
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            MainScreen(uiState = uiState)

        }
    }
}