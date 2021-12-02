package com.somethingsimple.core_impl.datasource

import android.content.SharedPreferences
import com.somethingsimple.core_api.datasource.AppPrefsDataSource
import java.util.*
import javax.inject.Inject

class AppPrefsDataSourceImpl @Inject constructor(
    private val preferences: SharedPreferences
) : AppPrefsDataSource {
    override fun getLastUpdateTime(): Date {
        return Date(preferences.getLong(LAST_UPDATE_KEY, 0L))
    }

    override fun saveLastUpdateTime(date: Date) {
        preferences
            .edit()
            .putLong(LAST_UPDATE_KEY, date.time)
            .apply()
    }

    companion object {
        private const val LAST_UPDATE_KEY = "last_update_time"
    }
}