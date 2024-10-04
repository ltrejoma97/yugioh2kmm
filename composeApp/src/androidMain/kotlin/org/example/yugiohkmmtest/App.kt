package org.example.yugiohkmmtest

import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import org.example.yugiohkmmtest.screens.MainScreen
import org.example.yugiohkmmtest.screens.Navigation
import org.example.yugiohkmmtest.viewModel.ListScreenViewModel
import org.example.yugiohkmmtest.viewModel.MainViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.androidx.compose.get

@Composable
fun App(mainViewModel: MainViewModel) {
    MaterialTheme {
        PreComposeApp {
            //val viewModel = MainViewModel(get(), get(), get())



//
//            val viewModel = viewModel(modelClass = MainViewModel::class) {
//              MainViewModel(CardRepoImpl(CardManager))
//            }
            //val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            //val uiState = viewModel.uiState
            //MainScreen(vm = mainViewModel)
            Navigation(mainViewModel)

        }
    }
}