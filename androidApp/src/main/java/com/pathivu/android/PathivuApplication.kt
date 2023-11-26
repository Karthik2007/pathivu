package com.pathivu.android

import android.app.Application
import com.pathivu.domain_words.wordsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PathivuApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PathivuApplication)
            // androidLogger()
            modules(wordsModule)
        }
    }
}