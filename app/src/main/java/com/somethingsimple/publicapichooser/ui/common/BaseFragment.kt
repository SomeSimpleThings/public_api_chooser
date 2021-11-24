package com.somethingsimple.publicapichooser.ui.common

import android.content.Context
import androidx.annotation.LayoutRes
import com.somethingsimple.publicapichooser.ApiChooserApp
import com.somethingsimple.publicapichooser.di.component.MainComponent
import moxy.MvpAppCompatFragment

abstract class BaseFragment(@LayoutRes contentLayoutId: Int) :
    MvpAppCompatFragment(contentLayoutId) {

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

}