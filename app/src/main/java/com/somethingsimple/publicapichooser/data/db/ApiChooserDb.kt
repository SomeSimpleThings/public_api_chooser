package com.somethingsimple.publicapichooser.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.somethingsimple.publicapichooser.data.vo.ApiEntry
import com.somethingsimple.publicapichooser.data.vo.Category

@Database(entities = [Category::class, ApiEntry::class], version = 2)
abstract class ApiChooserDb : RoomDatabase() {
    abstract fun categoriesDao(): CategoryDao
    abstract fun publicApiDao(): PublicApiDao
}