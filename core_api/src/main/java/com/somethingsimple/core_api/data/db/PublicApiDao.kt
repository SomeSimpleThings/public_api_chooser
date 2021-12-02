package com.somethingsimple.core_api.data.db

import androidx.room.*
import com.somethingsimple.core_api.data.db.entity.ApiEntryEntity
import com.somethingsimple.core_api.data.db.entity.CategorySynt
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe

@Dao
interface PublicApiDao {
    @Query("SELECT * FROM ApiEntryEntity")
    fun getPublicApis(): Maybe<List<ApiEntryEntity>>

    @Query("SELECT category FROM ApiEntryEntity GROUP BY category")
    fun getCategories(): Maybe<List<CategorySynt>>

    @Query("SELECT * FROM ApiEntryEntity WHERE category =:categoryName")
    fun getPublicApisByCategory(categoryName: String): Maybe<List<ApiEntryEntity>>

    @Query("SELECT * FROM ApiEntryEntity WHERE category =:categoryName LIMIT :count")
    fun getPublicApisByCategory(
        categoryName: String,
        count: Int = 3
    ): Maybe<List<ApiEntryEntity>>

//    @Query("SELECT * FROM ApiEntryEntity WHERE id =:id")
//    fun getPublicApiById(id: Long): Maybe<ApiEntryEntity>

    @Query("SELECT * FROM ApiEntryEntity WHERE api =:name LIMIT 1")
    fun getPublicApiByName(name: String): Maybe<ApiEntryEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(publicApis: List<ApiEntryEntity>): Completable

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun save(apiEntry: ApiEntryEntity): Completable
}