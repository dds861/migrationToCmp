package com.example.shared.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.example.shared.MainViewModel
import kotlinx.coroutines.Dispatchers


fun getDatabaseBuilder(ctx: Context): RoomDatabase.Builder<UserDatabase> {
    val appContext = ctx.applicationContext
    val dbFile = appContext.getDatabasePath("my_room.db")
    return Room.databaseBuilder<UserDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}

fun getDatabase(ctx: Context): UserDatabase {
    return getRoomDatabase(getDatabaseBuilder(ctx))
}
