package com.somethingsimple.feature_favourites.domain

import com.somethingsimple.feature_favourites.data.FavouritesRepository
import javax.inject.Inject

class FavouritesUseCase @Inject constructor(
    private val favouritesRepository: FavouritesRepository
) {

    fun getFavourites() = favouritesRepository.getFavourites()
}