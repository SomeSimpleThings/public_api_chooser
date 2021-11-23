package com.somethingsimple.publicapichooser.di.module.publicapi

import com.somethingsimple.publicapichooser.ui.api.details.ApiDetailsFragment
import com.somethingsimple.publicapichooser.ui.api.list.ApisFragment
import dagger.Module

@Module
abstract class PublicApiUiModule {
    abstract fun bindApisFragment(): ApisFragment

    abstract fun bindApiDetailsFragment(): ApiDetailsFragment
}