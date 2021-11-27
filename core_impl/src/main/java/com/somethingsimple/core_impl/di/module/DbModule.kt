package com.somethingsimple.core_impl.di.module

import android.content.Context
import androidx.room.Room
import com.somethingsimple.core_api.data.db.ApiChooserDb
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {
    @Singleton
    @Provides
    fun provideLocalStorage(context: Context): ApiChooserDb =
        Room
            .databaseBuilder(context, ApiChooserDb::class.java, "public_api.db")
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideCategoryDao(database: ApiChooserDb) = database.categoriesDao()

    @Singleton
    @Provides
    fun provideApiEntryDao(database: ApiChooserDb) = database.publicApiDao()
}