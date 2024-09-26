package org.example.yugiohkmmtest.domain.helpers


import org.example.yugiohkmmtest.domain.FlowWrapper
import org.example.yugiohkmmtest.domain.modelObjexts.YugiohCard
import org.example.yugiohkmmtest.domain.useCases.GetClassicCardsUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class GetClassicCardsUseCaseHelper():KoinComponent{
    private val useCase : GetClassicCardsUseCase by inject()

    suspend fun  invoke(): FlowWrapper<List<YugiohCard>> = FlowWrapper(useCase.invoke())

}