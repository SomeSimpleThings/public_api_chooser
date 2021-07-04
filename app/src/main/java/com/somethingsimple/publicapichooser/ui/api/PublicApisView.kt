package com.somethingsimple.publicapichooser.ui.api

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface PublicApisView : MvpView {
    fun init()
    fun updateList()
    fun addItemToList(position: Int)
    fun loadingError(text: String?)
}