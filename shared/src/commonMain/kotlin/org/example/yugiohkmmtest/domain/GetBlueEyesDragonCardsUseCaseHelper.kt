package org.example.yugiohkmmtest.domain

import org.example.yugiohkmmtest.data.LocalDataSource.DatabaseCard
import org.example.yugiohkmmtest.domain.DTO.CardDTOResponse
import org.example.yugiohkmmtest.domain.modelObjexts.YugiohCard
import org.example.yugiohkmmtest.domain.useCases.RealmTestUseCase
import org.example.yugiohkmmtest.domain.useCases.UseCaseResponse
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetBlueEyesDragonCardsUseCaseHelper : KoinComponent {
    private val useCase : GetBlueEyesDragonCardsUseCase by inject()
    @Throws(Exception::class) suspend fun callUseCase() : UseCaseResponse<List<YugiohCard>> = useCase.invoke()
    fun testChannel(): String = useCase.testChannel()

    @Throws(Exception::class) suspend fun callFlowFromUseCase() = useCase.testFlow()


}

class TestRealmHelper : KoinComponent{

    private val useCase: RealmTestUseCase by inject()

    suspend fun writePaddingtong() : Unit = useCase.writeTestChannel()

    suspend fun readPaddingtong(): String =  useCase.readTestChannel()
}