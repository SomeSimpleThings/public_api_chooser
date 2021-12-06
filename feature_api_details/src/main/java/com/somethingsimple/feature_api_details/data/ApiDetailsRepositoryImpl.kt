package com.somethingsimple.feature_api_details.data

import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.core_api.datasource.publicapi.LocalPublicApiDataSource
import com.somethingsimple.core_api.datasource.publicapi.PublicApiDataSource
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import javax.inject.Inject

class ApiDetailsRepositoryImpl @Inject constructor(
    private val localPublicApiDataSource: LocalPublicApiDataSource,
    private val remotePublicApiDataSource: PublicApiDataSource
) : ApiDetailsRepository {
    override fun getApiForName(name: String): Maybe<ApiEntry> {
        return localPublicApiDataSource.getApiByLink(name)
    }

//    override fun getApiById(id: Long): Maybe<ApiEntry> {
//        return localPublicApiDataSource.getApiById(id)
//    }

    override fun getApiByLink(link: String): Maybe<ApiEntry> {
        return localPublicApiDataSource.getApiByLink(link)
    }

    override fun saveOrDeleteFavourite(apiEntry: ApiEntry): Completable {
        return if (apiEntry.favourite)
            localPublicApiDataSource.removeFromFavourite(apiEntry)
        else
            localPublicApiDataSource.saveToFavourite(apiEntry)

    }


}