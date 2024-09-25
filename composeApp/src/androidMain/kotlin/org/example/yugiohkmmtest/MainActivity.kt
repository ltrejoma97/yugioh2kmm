package org.example.yugiohkmmtest

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

import org.example.yugiohkmmtest.viewModel.MainViewModel
import org.koin.android.ext.android.get


class MainActivity : ComponentActivity() {

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val mainViewModel : MainViewModel= MainViewModel(get(), get(),get())
            mainViewModel.testPersistenceRead()
            mainViewModel.testFlow()
            mainViewModel.getCards()
            App()
            //MainScreen(viewModel.uiState.value)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}