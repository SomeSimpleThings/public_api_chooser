package com.somethingsimple.core_api.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.somethingsimple.core_api.data.db.entity.ApiEntryEntity

@Database(
    entities = [ApiEntryEntity::class],
    version = 2,
    exportSchema = false
)
abstract class ApiChooserDb : RoomDatabase() {
    abstract fun publicApiDao(): PublicApiDao
}