package com.somethingsimple.publicapichooser.di.component

import android.app.Application
import android.content.Context
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.somethingsimple.core_api.di.provider.AppProvider
import com.somethingsimple.publicapichooser.ApiChooserApp
import com.somethingsimple.publicapichooser.di.module.AppModule
import com.somethingsimple.publicapichooser.di.module.category.CategoryModule
import com.somethingsimple.publicapichooser.di.module.publicapi.PublicApiModule
import com.somethingsimple.publicapichooser.schedulers.DefaultSchedulers
import com.somethingsimple.publicapichooser.schedulers.Schedulers
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class,
        CategoryModule::class,
        PublicApiModule::class
    ]
)
interface AppComponent : AppProvider {
    companion object {

        private var appComponent: AppComponent? = null
        fun create(application: Application): AppComponent {
            return appComponent ?: DaggerAppComponent
                .builder()
                .application(application)
                .apply {
                    val cicerone = Cicerone.create()
                    withRouter(cicerone.router)
                    withNavigatorHolder(cicerone.getNavigatorHolder())
                }
                .withSchedulers(DefaultSchedulers)
                .build()
        }
    }

    fun inject(app: ApiChooserApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(context: Context): Builder

        @BindsInstance
        fun withRouter(router: Router): Builder

        @BindsInstance
        fun withNavigatorHolder(navigatorHolder: NavigatorHolder): Builder

        @BindsInstance
        fun withSchedulers(schedulers: Schedulers): Builder

        fun build(): AppComponent
    }
}