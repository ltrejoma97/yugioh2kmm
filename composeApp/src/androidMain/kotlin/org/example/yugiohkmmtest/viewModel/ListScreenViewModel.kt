package org.example.yugiohkmmtest.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import org.example.yugiohkmmtest.domain.CardRepository
import org.example.yugiohkmmtest.model.CardModel

data class ListScreenUIState (
    val responseCards : List<CardModel> = emptyList()
)


class ListScreenViewModel(private val cardRepository: CardRepository): ViewModel() {

    private val _uiState = MutableStateFlow(ListScreenUIState())
    val uiState = _uiState.asStateFlow()


    fun getAllCards(){
       viewModelScope.launch(Dispatchers.IO) {
          val response =  cardRepository.getCards()
//          _uiState.value = ListScreenUIState(response)
           _uiState.update { state ->
               state.copy(responseCards = response)
           }
       }
   }


//    fun updateUiObject(listScreenUIState: ListScreenUIState) {
//        this.uiState = listScreenUIState
//    }

    init {
        getAllCards()
    }
}

