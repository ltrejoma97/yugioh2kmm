package org.example.yugiohkmmtest

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import moe.tlaster.precompose.viewmodel.viewModel
import org.example.yugiohkmmtest.data.CardManager
import org.example.yugiohkmmtest.data.CardRepoImpl
import org.example.yugiohkmmtest.screens.MainScreen
import org.example.yugiohkmmtest.viewModel.MainViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {

    MaterialTheme {
        PreComposeApp {

            val viewModel = viewModel(modelClass = MainViewModel::class) {
                MainViewModel(CardRepoImpl(CardManager))
            }
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            MainScreen(uiState = uiState)

        }
    }
}