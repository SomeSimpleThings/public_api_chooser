package com.somethingsimple.publicapichooser.ui

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.somethingsimple.publicapichooser.ui.category.CategoriesFragment

interface IScreens {
    fun categories(): Screen

}

object ApiChooserScreens : IScreens {

    override fun categories() = FragmentScreen { CategoriesFragment.newInstance() }
}