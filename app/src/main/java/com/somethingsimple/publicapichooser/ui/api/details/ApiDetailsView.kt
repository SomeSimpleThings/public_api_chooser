package com.somethingsimple.publicapichooser.ui.api.details

import com.somethingsimple.core_api.data.vo.ApiEntry
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ApiDetailsView : MvpView {
    fun init()
    fun showDetails(apiEntry: ApiEntry)
    fun showError(message: String?)
}