package org.example.yugiohkmmtest.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import org.example.yugiohkmmtest.data.repository.CardsRepository
import org.example.yugiohkmmtest.domain.CardRepository
import org.example.yugiohkmmtest.domain.GetBlueEyesDragonCardsUseCase
import org.example.yugiohkmmtest.domain.modelObjexts.YugiohCard
import org.example.yugiohkmmtest.domain.useCases.GetClassicCardsUseCase

class ListScreenViewModel(
    private val id: Int,
    private val cardRepository: CardsRepository,
    private val getGetBlueEyesDragonCardsUseCase: GetBlueEyesDragonCardsUseCase,
    private val getClassicCardsUseCase: GetClassicCardsUseCase

    ) : ViewModel() {

    var uiState: ListScreenUIState by mutableStateOf(ListScreenUIState())
        private set

    init {
//        viewModelScope.launch {
//            val response = getClassicCardsUseCase.invoke()
//            uiState = ListScreenUIState(
//                loading = false,
//                yugiohCard =
//            )
//        }
    }

    data class ListScreenUIState(
        val loading: Boolean = false,
        val yugiohCard: YugiohCard? = null,
    )
}