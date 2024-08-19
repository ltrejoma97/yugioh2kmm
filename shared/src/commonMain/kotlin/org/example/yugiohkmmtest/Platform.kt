package org.example.yugiohkmmtest

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform