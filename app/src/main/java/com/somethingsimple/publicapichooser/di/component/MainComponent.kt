package com.somethingsimple.publicapichooser.di.component

import com.somethingsimple.core_api.di.provider.CoreProvider
import com.somethingsimple.publicapichooser.di.scope.MainActivityScope
import com.somethingsimple.publicapichooser.ui.MainActivity
import dagger.Component

@MainActivityScope
@Component(dependencies = [CoreProvider::class])
interface MainComponent {
    fun inject(activity: MainActivity)

    companion object {
        fun create(coreProvider: CoreProvider): MainComponent {
            return DaggerMainComponent
                .builder()
                .coreProvider(coreProvider)
                .build()
        }
    }
}