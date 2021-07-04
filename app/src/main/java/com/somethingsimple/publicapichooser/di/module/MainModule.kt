package com.somethingsimple.publicapichooser.di.module

import com.somethingsimple.publicapichooser.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

}