package org.example.yugiohkmmtest

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

// platform Module


interface Platform {
    val name: String
}

expect fun getPlatform(): Platform