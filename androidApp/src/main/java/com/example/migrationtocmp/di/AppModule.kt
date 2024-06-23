package com.example.migrationtocmp.di

import com.example.migrationtocmp.data.UserDatabase
import com.example.migrationtocmp.data.UserRepository
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { UserDatabase.getDatabase(androidContext()).userDao() }
    single { UserRepository(get()) }

}