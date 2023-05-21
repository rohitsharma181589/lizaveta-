package com.example.ponkratovaelizaveta.di

import android.content.Context
import androidx.room.Room
import com.example.ponkratovaelizaveta.db.AppDatabase
import com.example.ponkratovaelizaveta.db.JokesDao
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
    fun provideLogDao(database: AppDatabase): JokesDao {
        return database.jokesDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "joke.db"
        ).build()
    }

}