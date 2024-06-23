package com.example.shared.di

import com.example.shared.data.UserDatabase
import com.example.shared.data.getDatabase
import org.koin.dsl.module

actual fun platformModule() = module {
    single<UserDatabase> { getDatabase() }
}
