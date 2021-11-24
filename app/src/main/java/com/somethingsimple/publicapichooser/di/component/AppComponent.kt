package com.somethingsimple.publicapichooser.di.component

import android.app.Application
import android.content.Context
import com.somethingsimple.core_api.di.provider.AppProvider
import com.somethingsimple.publicapichooser.ApiChooserApp
import com.somethingsimple.publicapichooser.di.module.AppModule
import com.somethingsimple.publicapichooser.di.module.publicapi.PublicApiModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class,
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
                .build()
        }
    }

    fun inject(app: ApiChooserApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(context: Context): Builder

        fun build(): AppComponent
    }
}