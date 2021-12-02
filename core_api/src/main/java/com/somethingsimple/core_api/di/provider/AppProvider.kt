package com.somethingsimple.core_api.di.provider

import android.content.Context
import android.content.SharedPreferences

interface AppProvider {

    fun getContext(): Context

    fun getPreferences(): SharedPreferences

}