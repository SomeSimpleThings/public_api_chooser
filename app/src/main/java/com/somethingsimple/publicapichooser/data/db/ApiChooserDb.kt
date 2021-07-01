package com.somethingsimple.publicapichooser.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.somethingsimple.publicapichooser.data.vo.Category

@Database(entities = [Category::class], version = 1)
abstract class ApiChooserDb : RoomDatabase() {
    abstract fun categoriesDao(): CategoryDao
}