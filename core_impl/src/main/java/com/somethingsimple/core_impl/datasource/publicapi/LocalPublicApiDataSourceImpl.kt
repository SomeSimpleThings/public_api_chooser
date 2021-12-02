package com.somethingsimple.core_impl.datasource.publicapi

import com.somethingsimple.core_api.data.db.PublicApiDao
import com.somethingsimple.core_api.data.db.entity.ApiEntryEntity
import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.core_api.data.vo.Category
import com.somethingsimple.core_api.datasource.publicapi.LocalPublicApiDataSource
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import javax.inject.Inject

class LocalPublicApiDataSourceImpl @Inject constructor(private val publicApiDao: PublicApiDao) :
    LocalPublicApiDataSource {
    override fun save(apis: List<ApiEntry>): Completable =
        publicApiDao.retain(apis.map { apiEntry ->
            ApiEntryEntity(
                apiEntry.id,
                apiEntry.api,
                apiEntry.auth,
                apiEntry.category,
                apiEntry.cors,
                apiEntry.description,
                apiEntry.isHttps,
                apiEntry.link
            )
        })


    override fun retain(apis: List<ApiEntry>): Maybe<List<ApiEntry>> {
        return publicApiDao
            .retain(apis.map { apiEntry ->
                ApiEntryEntity(
                    apiEntry.id,
                    apiEntry.api,
                    apiEntry.auth,
                    apiEntry.category,
                    apiEntry.cors,
                    apiEntry.description,
                    apiEntry.isHttps,
                    apiEntry.link
                )
            }).andThen(
                publicApiDao.getPublicApis()
                    .map { it.map { apiEntryEntity -> ApiEntry(apiEntryEntity) } }
            )
    }

    override fun retain(categoryName: String, apis: List<ApiEntry>): Maybe<List<ApiEntry>> =
        publicApiDao
            .retain(apis.map { apiEntry ->
                ApiEntryEntity(
                    apiEntry.id,
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


    override fun retain(apiEntry: ApiEntry): Maybe<ApiEntry> {
        return publicApiDao.retain(
            ApiEntryEntity(
                apiEntry.id,
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


    override fun getApiById(id: Long): Maybe<ApiEntry> =
        publicApiDao.getPublicApiById(id).map { ApiEntry(it) }

    override fun getApiByName(name: String): Maybe<ApiEntry> =
        publicApiDao.getPublicApiByName(name).map { ApiEntry(it) }

    override fun getCategories(): Maybe<List<Category>> {
        return publicApiDao.getCategories().map {
            it.map { categorySynt -> Category(categorySynt.category) }
        }
    }

    override fun getApiByCategory(categoryName: String): Maybe<List<ApiEntry>> =
        publicApiDao.getPublicApisByCategory(categoryName)
            .map { apiEntries ->
                apiEntries.map {
                    ApiEntry(it)
                }
            }

    override fun getApiByCategory(categoryName: String, count: Int): Maybe<List<ApiEntry>> =
        publicApiDao.getPublicApisByCategory(categoryName, count)
            .map { apiEntries ->
                apiEntries.map {
                    ApiEntry(it)
                }
            }
}