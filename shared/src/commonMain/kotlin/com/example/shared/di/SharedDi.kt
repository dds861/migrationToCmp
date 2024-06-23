package com.example.shared.di

import com.example.shared.MainViewModel
import com.example.shared.data.UserRepository
import org.koin.core.module.Module
import org.koin.dsl.module


expect fun platformModule(): Module

val sharedKoinModules = module {
    single<UserRepository> { UserRepository(get()) }
    single<MainViewModel> { MainViewModel(get()) }
}