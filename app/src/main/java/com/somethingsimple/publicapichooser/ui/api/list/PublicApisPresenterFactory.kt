package com.somethingsimple.publicapichooser.ui.api.list

import com.somethingsimple.publicapichooser.ui.IScreens
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory

@AssistedFactory
interface PublicApisPresenterFactory {

    fun create(
        @Assisted("category") category: String,
        @Assisted("screens") screens: IScreens
    ): PublicApisPresenter

}