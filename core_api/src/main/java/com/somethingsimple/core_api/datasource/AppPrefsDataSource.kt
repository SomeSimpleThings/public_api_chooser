package com.somethingsimple.core_api.datasource

import java.util.*

interface AppPrefsDataSource {
    fun getLastUpdateTime(): Date
    fun saveLastUpdateTime(date: Date)
}