package com.pathivu.domain_words

import compathivudomainwords.WordsSample

interface WordsRepository {
    suspend fun getWords(): List<WordsSample>
    fun getWords(query: String): List<WordsSample>
    suspend fun addWord()
}

class WordsRepositoryImpl(private val wordsDb: Words) : WordsRepository {
    override suspend fun getWords(): List<WordsSample> {
        return wordsDb.wordsQueries.get().executeAsList()
    }

    override fun getWords(query: String): List<WordsSample> {
        TODO("Not yet implemented")
    }

    override suspend fun addWord() {
        wordsDb.wordsQueries.add("日本") }
}