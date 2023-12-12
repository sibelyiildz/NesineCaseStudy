package com.example.nesinecasestudy.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [PostEntity::class],
    version = 1,
    exportSchema = false
)
abstract class PostDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}