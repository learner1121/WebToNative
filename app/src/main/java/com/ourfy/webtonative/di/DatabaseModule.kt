package com.ourfy.webtonative.di

import android.content.Context
import androidx.room.Room
import com.ourfy.webtonative.data.local.AppDatabase
import com.ourfy.webtonative.data.local.dao.UrlHistoryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlin.jvm.java

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "url_history_db"
        ).build()

    @Provides
    fun provideUrlHistoryDao(
        db: AppDatabase
    ): UrlHistoryDao = db.urlHistoryDao()
}
