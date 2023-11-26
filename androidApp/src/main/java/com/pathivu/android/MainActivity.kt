package com.pathivu.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.arkivanov.decompose.defaultComponentContext
import com.pathivu.main.MainComponentImpl
import com.pathivu.main.MainUi

class MainActivity : ComponentActivity() {

    // private val wordsRepo : WordsRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainComponent = MainComponentImpl(componentContext = defaultComponentContext())
        setContent {
            MainUi(component = mainComponent)
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {

    }
}
