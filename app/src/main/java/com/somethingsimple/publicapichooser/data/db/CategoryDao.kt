package com.somethingsimple.publicapichooser.data.db

import androidx.room.*
import com.somethingsimple.publicapichooser.data.vo.Category
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface CategoryDao {
    @Query("SELECT * FROM Category")
    fun getCategories(): Single<List<Category>>

    @Query("SELECT * FROM Category WHERE name =:name")
    fun getCategoryByName(name: String): Single<Category>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun retain(categories: List<Category>): Completable

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun retain(category: Category): Completable
}