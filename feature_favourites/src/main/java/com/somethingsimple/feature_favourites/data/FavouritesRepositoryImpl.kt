package com.somethingsimple.feature_favourites.data

import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.core_api.datasource.publicapi.LocalPublicApiDataSource
import io.reactivex.rxjava3.core.Maybe
import javax.inject.Inject

class FavouritesRepositoryImpl @Inject constructor(
    private val apiDataSource: LocalPublicApiDataSource
) :
    FavouritesRepository {
    override fun getFavourites(): Maybe<List<ApiEntry>> {
        return apiDataSource.getFavourites()
    }
}