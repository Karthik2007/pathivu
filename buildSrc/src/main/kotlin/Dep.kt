object Dep {
    object Koin {
        const val core = "io.insert-koin:koin-core:${Versions.koin}"
        const val test = "io.insert-koin:koin-test:${Versions.koin}"
        const val android = "io.insert-koin:koin-android:${Versions.koin}"
    }
    object SqlDelight {
        const val gradlePlugin = "com.squareup.sqldelight:gradle-plugin:${Versions.sqldelightPlugin}"
        const val runtime = "com.squareup.sqldelight:runtime:${Versions.sqldelight}"
        const val android = "com.squareup.sqldelight:android-driver:${Versions.sqldelight}"
        const val native = "com.squareup.sqldelight:native-driver:${Versions.sqldelight}"
    }
    object Decompose {
        const val core = "com.arkivanov.decompose:decompose:${Versions.decompose}"
        const val jetpackCompose = "com.arkivanov.decompose:extensions-compose-jetpack:${Versions.decompose}"
    }
    object Compose {
        const val ui = "androidx.compose.ui:ui:${Versions.compose}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
        const val foundation = "androidx.compose.foundation:foundation:${Versions.compose}"
        const val material = "androidx.compose.material:material:${Versions.compose}"
        const val activity = "androidx.activity:activity-compose:${Versions.composeActivity}"
    }
}