package com.somethingsimple.publicapichooser.ui.common

import android.content.Context
import androidx.annotation.LayoutRes
import com.somethingsimple.publicapichooser.ApiChooserApp
import moxy.MvpAppCompatFragment

abstract class BaseFragment(@LayoutRes contentLayoutId: Int) :
    MvpAppCompatFragment(contentLayoutId) {

    override fun onAttach(context: Context) {
//        (context.applicationContext as ApiChooserApp).getAppComponent().inject(this)
        super.onAttach(context)
    }

}