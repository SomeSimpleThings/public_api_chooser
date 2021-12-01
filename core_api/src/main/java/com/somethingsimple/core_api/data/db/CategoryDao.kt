package com.somethingsimple.core_api.data.db

import androidx.room.*
import com.somethingsimple.core_api.data.db.entity.CategoryEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single

@Dao
interface CategoryDao {
    @Query("SELECT * FROM CategoryEntity")
    fun getCategories(): Flowable<List<CategoryEntity>>

    @Query("SELECT * FROM CategoryEntity WHERE name =:name")
    fun getCategoryByName(name: String): Single<CategoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(categories: List<CategoryEntity>): Completable

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun save(category: CategoryEntity): Completable
}