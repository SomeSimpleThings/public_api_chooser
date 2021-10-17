package com.somethingsimple.publicapichooser.ui.common

interface ListPresenter<V : ItemView, T> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun addAll(newList: List<T>)
    fun getItemAtPos(pos: Int): T?
    fun getCount(): Int
    fun clear()
}

