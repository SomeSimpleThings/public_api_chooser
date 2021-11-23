package com.somethingsimple.publicapichooser

import android.app.Application
import com.somethingsimple.core_api.di.provider.AppWithComponent
import com.somethingsimple.core_api.di.provider.CoreProvider
import com.somethingsimple.publicapichooser.di.component.AppComponent

class ApiChooserApp : Application(), AppWithComponent {

    companion object {
        private var appComponent: AppComponent? = null
    }


    override fun onCreate() {
        super.onCreate()
        getAppComponent().inject(this)
    }

    fun getAppComponent(): AppComponent {
        return appComponent
            ?: AppComponent.create(this).also {
                appComponent = it
            }
    }

    override fun getComponent(): CoreProvider {
        TODO("Not yet implemented")
    }

}