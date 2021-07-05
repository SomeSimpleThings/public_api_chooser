package com.somethingsimple.publicapichooser.ui

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.somethingsimple.publicapichooser.ui.api.details.ApiDetailsFragment
import com.somethingsimple.publicapichooser.ui.api.list.ApisFragment
import com.somethingsimple.publicapichooser.ui.category.CategoriesFragment

interface IScreens {
    fun categories(): Screen
    fun apis(categoryName: String): Screen
    fun apiDetails(id: Long): Screen

}

object ApiChooserScreens : IScreens {
    override fun categories() = FragmentScreen { CategoriesFragment.newInstance() }

    override fun apis(categoryName: String): Screen =
        FragmentScreen { ApisFragment.newInstance(categoryName) }

    override fun apiDetails(id: Long): Screen {
        return FragmentScreen { ApiDetailsFragment.newInstance(id) }
    }
}