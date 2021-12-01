package com.somethingsimple.core_api.ui.common

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

open class BaseFragment : Fragment() {

    fun navigate(){
        findNavController()
    }
}