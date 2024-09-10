package org.example.yugiohkmmtest.viewModel


import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import org.example.yugiohkmmtest.domain.CardRepository
import org.example.yugiohkmmtest.domain.GetBlueEyesDragonCardsUseCase
import org.example.yugiohkmmtest.model.CardModel

data class CardsUiState(
    val cardsList: List<CardModel> = emptyList(),
)

class MainViewModel(private val getGetBlueEyesDragonCardsUseCase: GetBlueEyesDragonCardsUseCase,private val cardsRepository: CardRepository ) : ViewModel() {

    private val _uiState = MutableStateFlow(CardsUiState())
    val uiState = _uiState.asStateFlow()

    fun getCards(){
        viewModelScope.launch {
            val response = getGetBlueEyesDragonCardsUseCase.invoke()
            println(response)

        }
    }

//    private val allCards = repository.getCards()

    init {
//        getAllCards()
    }

//    private fun getAllCards() {
//        viewModelScope.launch {
//            _uiState.update { state ->
//                state.copy(cardsList = allCards)
//            }
//        }
//    }
}