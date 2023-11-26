package com.pathivu.domain_words

import org.koin.core.module.Module
import org.koin.dsl.module

val wordsModule: Module = module {
    single<WordsRepository> { WordsRepositoryImpl(wordsDb = Words(driver = get())) }
    single { DatabaseDriverFactory().createDriver() }
}