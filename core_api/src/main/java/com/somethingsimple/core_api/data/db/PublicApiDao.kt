package com.somethingsimple.core_api.data.db

import androidx.room.*
import com.somethingsimple.core_api.data.db.entity.ApiEntryEntity
import com.somethingsimple.core_api.data.db.entity.CategorySynt
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe

@Dao
interface PublicApiDao {
    @Query(API_ENTRIES_QUERY)
    fun getPublicApis(): Maybe<List<ApiEntryEntity>>

    @Query("SELECT category AS categoryName FROM ApiEntryEntity GROUP BY category")
    fun getCategories(): Maybe<List<CategorySynt>>

    @Query("$API_ENTRIES_QUERY WHERE category =:categoryName")
    fun getPublicApisByCategory(categoryName: String): Maybe<List<ApiEntryEntity>>

    @Query("$API_ENTRIES_QUERY WHERE category =:categoryName LIMIT :count")
    fun getPublicApisByCategory(
        categoryName: String,
        count: Int = 3
    ): Maybe<List<ApiEntryEntity>>

    @Query("$API_ENTRIES_QUERY WHERE api =:name LIMIT 1")
    fun getPublicApiByName(name: String): Maybe<ApiEntryEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(publicApis: List<ApiEntryEntity>): Completable

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun save(apiEntry: ApiEntryEntity): Completable

    @Query("$API_ENTRIES_QUERY WHERE link =:link LIMIT 1")
    fun getPublicApiByLink(link: String): Maybe<ApiEntryEntity>

    @Query(FAVOURITES_ENTRIES_QUERY)
    fun getFavourites(): Maybe<List<ApiEntryEntity>>

    companion object {
        private const val API_ENTRIES_QUERY = """
            SELECT  
                api, auth, category, cors, description, hTTPS, link,
                case when f.apiLink  = a.link then 1 else  0 end as favourite
            FROM  ApiEntryEntity   a 
            LEFT  JOIN  FavouritesEntity   f 
            ON  a.link = f.apiLink
            """

        private const val FAVOURITES_ENTRIES_QUERY = """
            SELECT  
                api, auth, category, cors, description, hTTPS, link,
                case when f.apiLink  = a.link then 1 else  0 end as favourite
            FROM  ApiEntryEntity   a 
            JOIN  FavouritesEntity   f 
            ON  a.link = f.apiLink
            """
    }
}