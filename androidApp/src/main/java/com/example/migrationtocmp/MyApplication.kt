package com.example.migrationtocmp

import android.app.Application
import com.example.migrationtocmp.di.viewModelsModule
import com.example.shared.di.platformModule
import com.example.shared.di.sharedKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(platformModule() + sharedKoinModules + viewModelsModule)
        }
    }
}