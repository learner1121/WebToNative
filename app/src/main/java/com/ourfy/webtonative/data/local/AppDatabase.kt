package com.ourfy.webtonative.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ourfy.webtonative.data.local.dao.UrlHistoryDao
import com.ourfy.webtonative.data.local.entity.UrlHistoryEntity

@Database(
    entities = [UrlHistoryEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun urlHistoryDao(): UrlHistoryDao
}
