package org.example.yugiohkmmtest

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import moe.tlaster.precompose.viewmodel.viewModel
import org.example.yugiohkmmtest.data.CardManager
import org.example.yugiohkmmtest.data.CardRepoImpl
import org.example.yugiohkmmtest.domain.CardRepository

import org.example.yugiohkmmtest.screens.MainScreen
import org.example.yugiohkmmtest.viewModel.MainViewModel
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import yugiohkmmtest.composeapp.generated.resources.Res
import yugiohkmmtest.composeapp.generated.resources.compose_multiplatform

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