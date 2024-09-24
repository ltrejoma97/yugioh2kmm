package org.example.yugiohkmmtest.domain

import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class FlowWrapper<T>(private val flow: Flow<T>) {

    private val scope = MainScope()

    fun watch(block: (T) -> Unit) {
        scope.launch {
            flow.collect { value -> block(value) }
        }
    }

    fun cancel() {
        scope.coroutineContext.cancel()
    }
}