package com.example.shared.data

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.example.shared.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import platform.Foundation.NSHomeDirectory

fun getDatabaseBuilder(): RoomDatabase.Builder<UserDatabase> {
    val dbFilePath = NSHomeDirectory() + "/my_room.db"
    return Room.databaseBuilder<UserDatabase>(
        name = dbFilePath,
        factory = { UserDatabase::class.instantiateImpl() }
    )
}

fun getDatabase(): UserDatabase {
    return getRoomDatabase(getDatabaseBuilder())
}