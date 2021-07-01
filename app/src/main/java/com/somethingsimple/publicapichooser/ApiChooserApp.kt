package com.somethingsimple.publicapichooser

import com.github.terrakok.cicerone.Cicerone
import com.somethingsimple.publicapichooser.di.DaggerApiChooserComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class ApiChooserApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerApiChooserComponent
            .builder()
            .withContext(applicationContext)
            .apply {
                val cicerone = Cicerone.create()
                withRouter(cicerone.router)
                withNavigatorHolder(cicerone.getNavigatorHolder())
            }
            .build()

}