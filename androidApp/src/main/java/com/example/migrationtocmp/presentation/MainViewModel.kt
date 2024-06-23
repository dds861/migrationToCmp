package com.example.migrationtocmp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.migrationtocmp.data.User
import com.example.migrationtocmp.data.UserDatabase
import com.example.migrationtocmp.data.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainViewModel(private val repository: UserRepository) : ViewModel() {
    val allUsers: Flow<List<User>> = repository.allUsers

    fun insert(user: User) = viewModelScope.launch {
        repository.insert(user)
    }

    fun update(user: User) = viewModelScope.launch {
        repository.update(user)
    }

    fun delete(user: User) = viewModelScope.launch {
        repository.delete(user)
    }

    fun deleteAll() = viewModelScope.launch {
        repository.deleteAll()
    }
}