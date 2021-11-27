package com.somethingsimple.core_api.di.module

import com.somethingsimple.core_api.common.DefaultSchedulers
import com.somethingsimple.core_api.common.DefaultSchedulersImpl
import dagger.Binds
import dagger.Module

@Module
abstract class DefaultSchedulersModule {

    @Binds
    abstract fun bindsSchedulers(defaults: DefaultSchedulersImpl): DefaultSchedulers
}