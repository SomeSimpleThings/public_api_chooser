package com.somethingsimple.publicapichooser

import android.app.Application
import com.somethingsimple.core_api.di.provider.AppWithComponent
import com.somethingsimple.core_api.di.provider.CoreProvider
import com.somethingsimple.publicapichooser.di.component.CoreComponent

class ApiChooserApp : Application(), AppWithComponent {

    companion object {
        private var coreComponent: CoreComponent? = null
    }


    override fun onCreate() {
        super.onCreate()
        getComponent()
    }


    override fun getComponent(): CoreProvider {
        return coreComponent
            ?: CoreComponent.create(this).also {
                coreComponent = it
            }
    }

}