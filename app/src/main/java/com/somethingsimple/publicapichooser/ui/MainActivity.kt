package com.somethingsimple.publicapichooser.ui

import android.os.Bundle
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.somethingsimple.publicapichooser.R
import com.somethingsimple.publicapichooser.ui.common.BackButtonListener
import moxy.MvpAppCompatActivity

class MainActivity : MvpAppCompatActivity(R.layout.activity_main) {
    private val navigator = AppNavigator(this, R.id.container)

    //    @Inject
    lateinit var router: Router

    //    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    override fun onCreate(savedInstanceState: Bundle?) {
//        MainComponent.create((application as ApiChooserApp).getAppComponent())
        super.onCreate(savedInstanceState)
        savedInstanceState ?: router.newRootScreen(ApiChooserScreens.categories())
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {
                return
            }
        }
    }
}