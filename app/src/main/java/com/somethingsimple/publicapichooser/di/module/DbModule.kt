package com.somethingsimple.publicapichooser.di.module

import android.content.Context
import androidx.room.Room
import com.somethingsimple.publicapichooser.data.db.ApiChooserDb
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {
    @Singleton
    @Provides
    fun provideDatabaseGitHubStorage(context: Context): ApiChooserDb =
        Room
            .databaseBuilder(context, ApiChooserDb::class.java, "public_api.db")
            .build()
}