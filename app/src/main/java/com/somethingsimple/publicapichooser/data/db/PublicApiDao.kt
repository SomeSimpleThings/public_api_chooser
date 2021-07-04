package com.somethingsimple.publicapichooser.data.db

import androidx.room.*
import com.somethingsimple.publicapichooser.data.vo.ApiEntry
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface PublicApiDao {
    @Query("SELECT * FROM ApiEntry")
    fun getPublicApis(): Single<List<ApiEntry>>

    @Query("SELECT * FROM ApiEntry WHERE category =:categoryName")
    fun getPublicApisByCategory(categoryName: String): Single<List<ApiEntry>>

    @Query("SELECT * FROM ApiEntry WHERE id =:id")
    fun getPublicApiById(id: Long): Single<ApiEntry>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun retain(publicApis: List<ApiEntry>): Completable

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun retain(apiEntry: ApiEntry): Completable
}