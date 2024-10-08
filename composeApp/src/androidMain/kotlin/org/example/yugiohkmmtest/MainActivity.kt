package org.example.yugiohkmmtest

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import org.example.yugiohkmmtest.viewModel.ListScreenViewModel

import org.example.yugiohkmmtest.viewModel.MainViewModel
import org.koin.android.ext.android.get


class MainActivity : ComponentActivity() {

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val mainViewModel : MainViewModel= remember {
                MainViewModel(get(), get(), get())
            }
//            val listScreenViewModel : ListScreenViewModel = remember {
//                ListScreenViewModel(get(), get(), get(), get())
//            }
            LaunchedEffect(Unit){
                mainViewModel.testPersistenceWrite()
                mainViewModel.getCards()
            }

            App(mainViewModel)
            //MainScreen(viewModel.uiState.value)
        }
    }
}

