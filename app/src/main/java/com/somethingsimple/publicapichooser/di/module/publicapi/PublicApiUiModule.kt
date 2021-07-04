package com.somethingsimple.publicapichooser.di.module.publicapi

import com.somethingsimple.publicapichooser.ui.api.ApiDetailsFragment
import com.somethingsimple.publicapichooser.ui.api.ApisFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PublicApiUiModule {
    @ContributesAndroidInjector
    abstract fun bindApisFragment(): ApisFragment

    @ContributesAndroidInjector
    abstract fun bindApiDetailsFragment(): ApiDetailsFragment
}