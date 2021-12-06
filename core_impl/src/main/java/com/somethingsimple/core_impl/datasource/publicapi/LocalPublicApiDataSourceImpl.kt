package com.somethingsimple.core_impl.datasource.publicapi

import com.somethingsimple.core_api.data.db.FavouriteDao
import com.somethingsimple.core_api.data.db.PublicApiDao
import com.somethingsimple.core_api.data.db.entity.ApiEntryEntity
import com.somethingsimple.core_api.data.db.entity.FavouritesEntity
import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.core_api.data.vo.Category
import com.somethingsimple.core_api.datasource.publicapi.LocalPublicApiDataSource
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import javax.inject.Inject

class LocalPublicApiDataSourceImpl @Inject constructor(
    private val publicApiDao: PublicApiDao,
    private val favouriteDao: FavouriteDao
) :
    LocalPublicApiDataSource {

    override fun save(apiEntry: ApiEntry): Completable {
        return publicApiDao.save(
            ApiEntryEntity(
                apiEntry.api,
                apiEntry.auth,
                apiEntry.category,
                apiEntry.cors,
                apiEntry.description,
                apiEntry.isHttps,
                apiEntry.link
            )
        )
    }

    override fun save(apis: List<ApiEntry>): Completable =
        publicApiDao.save(apis.map { apiEntry ->
            ApiEntryEntity(
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
        return save(apis).andThen(
            publicApiDao.getPublicApis()
                .map { it.map { apiEntryEntity -> ApiEntry(apiEntryEntity) } }
        )
    }

    override fun retain(categoryName: String, apis: List<ApiEntry>): Maybe<List<ApiEntry>> =
        save(apis)
            .andThen(getApiByCategory(categoryName))


    override fun retain(apiEntry: ApiEntry): Maybe<ApiEntry> {
        return save(apiEntry)
            .andThen(publicApiDao.getPublicApiByName(apiEntry.api).map {
                ApiEntry(it)
            })
    }

//    override fun getApiById(id: Long): Maybe<ApiEntry> =
//        publicApiDao.getPublicApiById(id).map { ApiEntry(it) }

    override fun getApiByLink(link: String): Maybe<ApiEntry> =
        publicApiDao.getPublicApiByLink(link).map { ApiEntry(it) }

    override fun getCategories(): Maybe<List<Category>> {
        return publicApiDao.getCategories().map {
            it.map { categorySynt -> Category(categorySynt.categoryName) }
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

    override fun saveToFavourite(apiEntry: ApiEntry): Completable {
        return favouriteDao.insert(FavouritesEntity(0, apiEntry.link))
    }

    override fun removeFromFavourite(apiEntry: ApiEntry): Completable =
        favouriteDao.delete(apiEntry.link)

    override fun getFavourites(): Maybe<List<ApiEntry>> {
        return publicApiDao.getFavourites().map { apiEntries ->
            apiEntries.map {
                ApiEntry(it)
            }
        }
    }

}