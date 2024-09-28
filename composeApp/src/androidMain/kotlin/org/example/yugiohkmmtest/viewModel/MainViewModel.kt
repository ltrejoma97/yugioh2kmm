package org.example.yugiohkmmtest.viewModel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import org.example.yugiohkmmtest.domain.CardRepository
import org.example.yugiohkmmtest.domain.DTO.CardDto
import org.example.yugiohkmmtest.domain.GetBlueEyesDragonCardsUseCase
import org.example.yugiohkmmtest.domain.modelObjexts.YugiohCard
import org.example.yugiohkmmtest.domain.useCases.GetClassicCardsUseCase
import org.example.yugiohkmmtest.domain.useCases.RealmTestUseCase
import org.example.yugiohkmmtest.domain.useCases.UseCaseResponse
import org.example.yugiohkmmtest.model.CardsList

data class CardsUiState(
    val cardsList: List<YugiohCard> = emptyList(),
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
            getClassicCardsUseCase.invoke().onStart {
                println("Comenzando El Flow")
            }.collect {
                uiState = CardsUiState(
                    cardsList = it
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