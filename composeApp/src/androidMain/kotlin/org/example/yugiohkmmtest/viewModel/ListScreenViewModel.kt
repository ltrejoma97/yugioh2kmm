package org.example.yugiohkmmtest.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import org.example.yugiohkmmtest.domain.CardRepository

class ListScreenViewModel(private val cardRepository: CardRepository): ViewModel() {

    var uiState : ListScreenUIState by mutableStateOf(ListScreenUIState())
        private set

    fun getAllCards(){
       viewModelScope.launch(Dispatchers.IO) {
          val response =  cardRepository.getCards()
           if (response.length>5){
               updateUiObject(uiState.copy(responseCards = response.take(100)))
           }
       }
   }


    fun updateUiObject(listScreenUIState: ListScreenUIState) {
        this.uiState = listScreenUIState
    }

//    init {
//        getAllCards()
//        println("HOLA")
//    }

}

data class ListScreenUIState (
    val responseCards : String = "",

)