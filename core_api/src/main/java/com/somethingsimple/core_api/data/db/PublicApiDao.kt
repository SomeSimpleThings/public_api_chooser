package com.somethingsimple.core_api.data.db

import androidx.room.*
import com.somethingsimple.core_api.data.db.entity.ApiEntryEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface PublicApiDao {
    @Query("SELECT * FROM ApiEntryEntity")
    fun getPublicApis(): Single<List<ApiEntryEntity>>

    @Query("SELECT * FROM ApiEntryEntity WHERE category =:categoryName")
    fun getPublicApisByCategory(categoryName: String): Single<List<ApiEntryEntity>>

    @Query("SELECT * FROM ApiEntryEntity WHERE id =:id")
    fun getPublicApiById(id: Long): Single<ApiEntryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun retain(publicApis: List<ApiEntryEntity>): Completable

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun retain(apiEntry: ApiEntryEntity): Completable
}