package com.somethingsimple.publicapichooser.di.component

import com.somethingsimple.core_api.di.provider.CoreProvider
import com.somethingsimple.publicapichooser.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [CoreProvider::class],

    )
interface MainComponent {


    companion object {
        fun create(coreProvider: CoreProvider): MainComponent {
            return DaggerMainComponent
                .builder()
                .coreProvider(coreProvider)
                .build()
        }
    }

    fun inject(activity: MainActivity)
}