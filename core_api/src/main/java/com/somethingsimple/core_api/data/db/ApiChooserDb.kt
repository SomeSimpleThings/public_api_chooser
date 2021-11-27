package com.somethingsimple.core_api.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.somethingsimple.core_api.data.db.entity.ApiEntryEntity
import com.somethingsimple.core_api.data.db.entity.CategoryEntity

@Database(entities = [CategoryEntity::class, ApiEntryEntity::class], version = 1)
abstract class ApiChooserDb : RoomDatabase() {
    abstract fun categoriesDao(): CategoryDao
    abstract fun publicApiDao(): PublicApiDao
}