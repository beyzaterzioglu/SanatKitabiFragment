package com.beyzaterzioglu.sanatkitabifragment.room_db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.beyzaterzioglu.sanatkitabifragment.model.Pic

@Database(entities=[Pic::class],version=1)
abstract class PicDatabase:RoomDatabase() {
    abstract fun picDao(): PicDao
}