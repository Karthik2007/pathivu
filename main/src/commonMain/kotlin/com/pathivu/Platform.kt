package com.pathivu

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform