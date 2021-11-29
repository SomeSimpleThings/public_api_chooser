package com.somethingsimple.publicapichooser.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.somethingsimple.feature_categories.ui.category.CategoriesFragment
import com.somethingsimple.publicapichooser.ApiChooserApp
import com.somethingsimple.publicapichooser.R
import com.somethingsimple.publicapichooser.di.component.MainComponent

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        MainComponent.create((application as ApiChooserApp).getComponent()).inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        val fragment = CategoriesFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.container, fragment).commit()
    }

    override fun onPause() {
        super.onPause()
    }

}