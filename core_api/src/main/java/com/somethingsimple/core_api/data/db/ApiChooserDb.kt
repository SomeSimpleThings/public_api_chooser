package com.somethingsimple.core_api.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.somethingsimple.core_api.data.db.entity.ApiEntryEntity
import com.somethingsimple.core_api.data.db.entity.FavouritesEntity

@Database(
    entities = [ApiEntryEntity::class, FavouritesEntity::class],
    version = 2,
    exportSchema = false
)
abstract class ApiChooserDb : RoomDatabase() {
    abstract fun publicApiDao(): PublicApiDao
    abstract fun favouriteDao(): FavouriteDao
}