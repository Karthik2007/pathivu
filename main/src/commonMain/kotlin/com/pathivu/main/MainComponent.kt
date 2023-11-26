package com.pathivu.main

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

interface MainComponent {
    val stack: Value<ChildStack<*, MainDestination>>
}

class MainComponentImpl(
    componentContext: ComponentContext,
) : MainComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    override val stack: Value<ChildStack<*, MainDestination>> =
        childStack(
            source = navigation,
            initialConfiguration = Config.Dashboard,
            handleBackButton = true,
            childFactory = ::child,
        )

    private fun child(config: Config, childComponentContext: ComponentContext): MainDestination =
        when (config) {
            is Config.Dashboard -> MainDestination.Dashboard
        }

    private sealed interface Config : Parcelable {
        @Parcelize
        data object Dashboard : Config
    }
}

sealed class MainDestination {
    data object Dashboard : MainDestination()
}