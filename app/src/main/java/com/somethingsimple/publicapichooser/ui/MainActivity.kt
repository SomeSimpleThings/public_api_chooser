package com.somethingsimple.publicapichooser.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.somethingsimple.publicapichooser.ApiChooserApp
import com.somethingsimple.publicapichooser.R
import com.somethingsimple.publicapichooser.di.component.MainComponent


class MainActivity : FragmentActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        MainComponent.create((application as ApiChooserApp).getComponent()).inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpNavigation()
    }

    private fun setUpNavigation() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        NavigationUI.setupWithNavController(
            bottomNavigationView,
            navHostFragment.navController
        )
    }

    override fun onStart() {
        super.onStart()
        navController = findNavController(R.id.nav_host_fragment)
    }

    override fun onPause() {
        super.onPause()
    }

}