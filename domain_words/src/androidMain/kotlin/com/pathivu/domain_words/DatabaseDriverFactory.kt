package com.pathivu.domain_words

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

actual class DatabaseDriverFactory actual constructor(): KoinComponent{
    private val context: Context by inject()
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(Words.Schema, context, "test.db")
    }
}