package org.example.yugiohkmmtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.example.yugiohkmmtest.screens.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val viewModel : MainViewModel by viewModels()
        setContent {
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