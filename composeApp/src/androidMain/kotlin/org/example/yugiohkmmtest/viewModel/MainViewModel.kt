package org.example.yugiohkmmtest.viewModel


import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import org.example.yugiohkmmtest.domain.CardRepository
import org.example.yugiohkmmtest.domain.GetBlueEyesDragonCardsUseCase
import org.example.yugiohkmmtest.model.CardsList

data class CardsUiState(
    val cardsList: List<CardsList> = emptyList(),
)

class MainViewModel(private val repository: CardRepository, ) : ViewModel() {

    private val _uiState = MutableStateFlow(CardsUiState())
    val uiState = _uiState.asStateFlow()

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