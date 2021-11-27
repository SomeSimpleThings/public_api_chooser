package com.somethingsimple.publicapichooser.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.somethingsimple.feature_categories.ui.category.CategoriesFragment
import com.somethingsimple.publicapichooser.ApiChooserApp
import com.somethingsimple.publicapichooser.R
import com.somethingsimple.publicapichooser.di.component.MainComponent
import javax.inject.Inject

class MainActivity : FragmentActivity() {
    private val navigator = AppNavigator(this, R.id.container)

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        MainComponent.create((application as ApiChooserApp).getComponent()).inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        savedInstanceState ?: router.newRootScreen(ApiChooserScreens.categories())
    }

    override fun onStart() {
        super.onStart()
        val fragment = CategoriesFragment()
        supportFragmentManager.beginTransaction().add(R.id.container, fragment).commit()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
//        navigatorHolder.removeNavigator()
    }

//    override fun onBackPressed() {
//        supportFragmentManager.fragments.forEach {
//            if (it is BackButtonListener && it.backPressed()) {
//                return
//            }
//        }
//    }
}