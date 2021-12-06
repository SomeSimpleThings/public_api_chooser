package com.somethingsimple.feature_favourites.data

import com.somethingsimple.core_api.data.vo.ApiEntry
import io.reactivex.rxjava3.core.Maybe

interface FavouritesRepository {

    fun getFavourites(): Maybe<List<ApiEntry>>

}