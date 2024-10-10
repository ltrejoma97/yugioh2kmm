package org.example.yugiohkmmtest.viewModel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import org.example.yugiohkmmtest.domain.GetBlueEyesDragonCardsUseCase
import org.example.yugiohkmmtest.domain.modelObjexts.YugiohCard
import org.example.yugiohkmmtest.domain.useCases.GetClassicCardsUseCase
import org.example.yugiohkmmtest.domain.useCases.RealmTestUseCase

data class CardsUiState(
    val cardsList: List<YugiohCard> = emptyList(),
    val loading: Boolean = false
)

class MainViewModel(
    private val getGetBlueEyesDragonCardsUseCase: GetBlueEyesDragonCardsUseCase,
    private val getClassicCardsUseCase: GetClassicCardsUseCase,
    private val realmTestUseCase: RealmTestUseCase,
) : ViewModel() {

//    private val _uiState = MutableStateFlow(CardsUiState())
//    val uiState = _uiState.asStateFlow()

    var uiState by mutableStateOf(CardsUiState())
        private set

    fun getCards() {
//        viewModelScope.launch {
//            val response = getGetBlueEyesDragonCardsUseCase.invoke()
//            uiState = response.data?.let {
//                CardsUiState(
//                    cardsList = it)
//            } ?: CardsUiState()
//        }

        viewModelScope.launch {
            uiState = CardsUiState(loading = true)
            delay(1000)
            getClassicCardsUseCase.invoke().onStart {
                println("Comenzando El Flow")
            }.collect {
                uiState = CardsUiState(
                    cardsList = it,
                    loading = false
                )
            } ?: CardsUiState()
        }
    }

    fun testPersistenceWrite() {
        viewModelScope.launch(Dispatchers.IO) {
            getClassicCardsUseCase.invoke()
        }
    }

    fun testPersistenceRead() {
        viewModelScope.launch(Dispatchers.IO) {
            realmTestUseCase.readTestChannel()
        }
    }

    fun testFlow() {
        viewModelScope.launch {
            getGetBlueEyesDragonCardsUseCase.testFlow().onStart {
                println("iniciando el flow")
            }.collect {
                println(it)
            }
        }
    }

    init {
        //getAllCards()
        getCards()
    }
}