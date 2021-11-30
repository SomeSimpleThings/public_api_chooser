package com.somethingsimple.core_api.datasource.publicapi.local

import com.somethingsimple.core_api.data.db.PublicApiDao
import com.somethingsimple.core_api.data.db.entity.ApiEntryEntity
import com.somethingsimple.core_api.data.vo.ApiEntry
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class LocalPublicApiDataSourceImpl @Inject constructor(private val publicApiDao: PublicApiDao) :
    LocalPublicApiDataSource {
    override fun retain(categoryName: String, apis: List<ApiEntry>): Single<List<ApiEntry>> =
        publicApiDao
            .retain(apis.map { apiEntry ->
                ApiEntryEntity(
                    0,
                    apiEntry.api,
                    apiEntry.auth,
                    apiEntry.category,
                    apiEntry.cors,
                    apiEntry.description,
                    apiEntry.isHttps,
                    apiEntry.link
                )
            })
            .andThen(getApiByCategory(categoryName))


    override fun retain(apiEntry: ApiEntry): Single<ApiEntry> {
        return publicApiDao.retain(
            ApiEntryEntity(
                0,
                apiEntry.api,
                apiEntry.auth,
                apiEntry.category,
                apiEntry.cors,
                apiEntry.description,
                apiEntry.isHttps,
                apiEntry.link
            )
        ).andThen(publicApiDao.getPublicApiByName(apiEntry.api).map {
            ApiEntry(it)
        })
    }


    override fun getApiById(id: Long): Single<ApiEntry> =
        publicApiDao.getPublicApiById(id).map { ApiEntry(it) }

    override fun getApiByName(name: String): Single<ApiEntry> =
        publicApiDao.getPublicApiByName(name).map { ApiEntry(it) }


    override fun getApiByCategory(categoryName: String): Single<List<ApiEntry>> =
        publicApiDao.getPublicApisByCategory(categoryName)
            .map { apiEntries ->
                apiEntries.map {
                    ApiEntry(it)
                }
            }

    override fun getApiByCategory(categoryName: String, count: Int): Single<List<ApiEntry>> =
        publicApiDao.getPublicApisByCategory(categoryName, count)
            .map { apiEntries ->
                apiEntries.map {
                    ApiEntry(it)
                }
            }


}