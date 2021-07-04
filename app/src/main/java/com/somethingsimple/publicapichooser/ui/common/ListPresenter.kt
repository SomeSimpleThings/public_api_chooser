package com.somethingsimple.publicapichooser.ui.common

interface ListPresenter<V : ItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}

