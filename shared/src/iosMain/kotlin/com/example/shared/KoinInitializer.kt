package com.example.shared

import com.example.shared.di.platformModule
import com.example.shared.di.sharedKoinModules
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(platformModule() + sharedKoinModules)
    }

    class MainInjector: KoinComponent {
    }
}