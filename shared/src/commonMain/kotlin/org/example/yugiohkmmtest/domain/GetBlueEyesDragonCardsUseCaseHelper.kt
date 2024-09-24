package org.example.yugiohkmmtest.domain

import kotlinx.coroutines.flow.Flow
import org.example.yugiohkmmtest.domain.DTO.CardDTOResponse
import org.example.yugiohkmmtest.domain.useCases.RealmTestUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetBlueEyesDragonCardsUseCaseHelper : KoinComponent {
    private val useCase : GetBlueEyesDragonCardsUseCase by inject()
    @Throws(Exception::class) suspend fun callUseCase() : CardDTOResponse = useCase.invoke()
    fun testChannel(): String = useCase.testChannel()


 fun testFlow() : FlowWrapper<String> = FlowWrapper(useCase.testFlow())
}

class TestRealmHelper : KoinComponent{

    private val useCase: RealmTestUseCase by inject()

    suspend fun writePaddingtong() : Unit = useCase.writeTestChannel()

    suspend fun readPaddingtong(): String =  useCase.readTestChannel()
}