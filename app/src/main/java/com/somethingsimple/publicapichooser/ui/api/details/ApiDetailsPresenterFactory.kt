package com.somethingsimple.publicapichooser.ui.api.details

import com.somethingsimple.publicapichooser.ui.IScreens
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory


@AssistedFactory
interface ApiDetailsPresenterFactory {
    fun create(
        @Assisted("id") id: String,
        @Assisted("screens") screens: IScreens
    ): ApiDetailsPresenter

}