package com.somethingsimple.feature_api_details.data

import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.core_api.datasource.publicapi.PublicApiDataSource
import com.somethingsimple.core_api.datasource.publicapi.local.LocalPublicApiDataSource
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ApiDetailsRepositoryImpl @Inject constructor(
    private val localPublicApiDataSource: LocalPublicApiDataSource,
    private val remotePublicApiDataSource: PublicApiDataSource
) : ApiDetailsRepository {
    override fun getApiForName(name: String): Single<ApiEntry> {
        return localPublicApiDataSource.getApiByName(name)
    }

    override fun getApiById(id: Long): Single<ApiEntry> {
        return localPublicApiDataSource.getApiById(id)
    }


}