package com.somethingsimple.publicapichooser.di.module

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences =
        context.getSharedPreferences(PREFS_DEFAULT, Context.MODE_PRIVATE)

    companion object {
        private const val PREFS_DEFAULT = "publicapi_prefs"
    }
}