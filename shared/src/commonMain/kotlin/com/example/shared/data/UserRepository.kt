package com.example.shared.data

import kotlinx.coroutines.flow.Flow

class UserRepository(private val database: UserDatabase) {


    private val userDao: UserDao by lazy {
        database.userDao()
    }

    val allUsers: Flow<List<User>> = userDao.getUsers()

    suspend fun insert(user: User) {
        userDao.insert(user)
    }

    suspend fun update(user: User) {
        userDao.update(user)
    }

    suspend fun delete(user: User) {
        userDao.delete(user)
    }

    suspend fun deleteAll() {
        userDao.deleteAll()
    }
}