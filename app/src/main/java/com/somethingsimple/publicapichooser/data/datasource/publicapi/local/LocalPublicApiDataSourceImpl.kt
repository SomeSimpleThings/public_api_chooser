package com.somethingsimple.publicapichooser.data.datasource.publicapi.local

import com.somethingsimple.publicapichooser.data.db.ApiChooserDb
import com.somethingsimple.publicapichooser.data.db.PublicApiDao
import com.somethingsimple.publicapichooser.data.vo.ApiEntry
import io.reactivex.rxjava3.core.Single

class LocalPublicApiDataSourceImpl(db: ApiChooserDb) : LocalPublicApiDataSource {
    private val publicApiDao: PublicApiDao = db.publicApiDao()
    override fun retain(categoryName: String, apis: List<ApiEntry>): Single<List<ApiEntry>> =
        publicApiDao
            .retain(apis)
            .andThen(getApiByCategory(categoryName))


    override fun retain(apiEntry: ApiEntry): Single<ApiEntry> {
        TODO("Not yet implemented")
    }

    override fun getApiById(id: Long): Single<ApiEntry> =
        publicApiDao.getPublicApiById(id)


    override fun getApiByCategory(categoryName: String): Single<List<ApiEntry>> =
        publicApiDao.getPublicApisByCategory(categoryName)

}