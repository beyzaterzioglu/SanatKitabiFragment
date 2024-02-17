package com.beyzaterzioglu.sanatkitabifragment.room_db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.beyzaterzioglu.sanatkitabifragment.model.Pic
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface PicDao {
    @Query("SELECT * FROM pic")
    fun getAll():Flowable<List<Pic>>
    @Insert
    fun insert(pic:Pic):Completable
    @Delete
    fun delete(pic:Pic):Completable

    @Query("SELECT * FROM Pic WHERE id = :id")
    fun getPicById(id: Int): Flowable<Pic>
}