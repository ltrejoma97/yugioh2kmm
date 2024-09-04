package org.example.yugiohkmmtest

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.example.yugiohkmmtest.domain.GetBlueEyesDragonCardsUseCase
import org.example.yugiohkmmtest.viewModel.MainViewModel
import org.koin.android.ext.android.get
import org.koin.androidx.compose.get
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.java.KoinJavaComponent.inject

class MainActivity : ComponentActivity() {
//    val presenter: GetBlueEyesDragonCardsUseCase by inject(get())

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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