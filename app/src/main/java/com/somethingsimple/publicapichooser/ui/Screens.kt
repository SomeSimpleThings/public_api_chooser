package com.somethingsimple.publicapichooser.ui

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.somethingsimple.publicapichooser.ui.api.ApisFragment
import com.somethingsimple.publicapichooser.ui.category.CategoriesFragment

interface IScreens {
    fun categories(): Screen
    fun apis(categoryName: String): Screen

}

object ApiChooserScreens : IScreens {
    override fun categories() = FragmentScreen { CategoriesFragment.newInstance() }
    override fun apis(categoryName: String): Screen =
        FragmentScreen { ApisFragment.newInstance(categoryName) }
}