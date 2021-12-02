package com.somethingsimple.core_api.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.somethingsimple.core_api.data.db.entity.FavouritesEntity
import io.reactivex.rxjava3.core.Completable

@Dao
interface FavouriteDao {

    @Insert
    fun insert(favouritesEntity: FavouritesEntity): Completable

    @Query("DELETE from FavouritesEntity Where apiLink=:link")
    fun delete(link: String): Completable
}