package com.somethingsimple.publicapichooser.di.component

import com.somethingsimple.core_api.di.provider.CoreProvider
import com.somethingsimple.publicapichooser.ui.MainActivity
import com.somethingsimple.publicapichooser.ui.common.BaseFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [CoreProvider::class],
)
interface MainComponent {


    companion object {
        private var mainComponent: MainComponent? = null

        fun create(coreProvider: CoreProvider): MainComponent {
            return mainComponent ?: DaggerMainComponent
                .builder()
                .coreProvider(coreProvider)
                .build().also {
                    mainComponent = it
                }
        }
    }

    fun inject(activity: MainActivity)
    fun inject(fragment: BaseFragment)
}