package com.example.nesinecasestudy.di

import android.content.Context
import androidx.room.Room
import com.example.nesinecasestudy.BuildConfig
import com.example.nesinecasestudy.data.local.PostDao
import com.example.nesinecasestudy.data.local.PostDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): PostDatabase {
        return Room.databaseBuilder(
            appContext,
            PostDatabase::class.java,
            BuildConfig.DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(postDatabase: PostDatabase): PostDao {
        return postDatabase.postDao()
    }
}
