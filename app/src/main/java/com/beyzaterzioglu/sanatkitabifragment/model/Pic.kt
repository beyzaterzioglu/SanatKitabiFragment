package com.beyzaterzioglu.sanatkitabifragment.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Pic(
    @ColumnInfo(name = "picName")
    var picName : String,

    @ColumnInfo(name = "artistName")
    var artistName: String?,


    @ColumnInfo(name = "imageView")
    var image : ByteArray?

) {
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}