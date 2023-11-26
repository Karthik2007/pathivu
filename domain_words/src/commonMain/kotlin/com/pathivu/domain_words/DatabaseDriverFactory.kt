package com.pathivu.domain_words

import com.squareup.sqldelight.db.SqlDriver


expect class DatabaseDriverFactory() {
    fun createDriver(): SqlDriver
}