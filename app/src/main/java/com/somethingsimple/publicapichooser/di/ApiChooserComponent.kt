package com.somethingsimple.publicapichooser.di

import android.content.Context
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.somethingsimple.publicapichooser.ApiChooserApp
import com.somethingsimple.publicapichooser.di.module.MainModule
import com.somethingsimple.publicapichooser.di.module.category.CategoryModule
import com.somethingsimple.publicapichooser.schedulers.Schedulers
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        MainModule::class,
        CategoryModule::class,
    ]
)
interface ApiChooserComponent : AndroidInjector<ApiChooserApp> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withRouter(router: Router): Builder

        @BindsInstance
        fun withNavigatorHolder(navigatorHolder: NavigatorHolder): Builder

        @BindsInstance
        fun withSchedulers(schedulers: Schedulers): Builder

        fun build(): ApiChooserComponent

    }
}


