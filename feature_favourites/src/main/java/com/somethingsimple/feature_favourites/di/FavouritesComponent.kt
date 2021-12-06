package com.somethingsimple.feature_favourites.di

import com.somethingsimple.core_api.di.provider.CoreProvider
import com.somethingsimple.feature_favourites.ui.FavouritesFragment
import dagger.Component

@Component(
    dependencies = [CoreProvider::class],
    modules = [FavouritesModule::class]
)
@FavouritesScope
interface FavouritesComponent {

    companion object {
        fun create(coreProvider: CoreProvider): FavouritesComponent {
            return DaggerFavouritesComponent
                .builder()
                .coreProvider(coreProvider)
                .build()
        }
    }

    fun inject(favouritesFragment: FavouritesFragment)

}