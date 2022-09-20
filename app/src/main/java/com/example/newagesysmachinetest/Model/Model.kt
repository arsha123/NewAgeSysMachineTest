package com.example.newagesysmachinetest.Model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "catimg", indices = arrayOf(Index(value = ["id"], unique = true)))
class Model {


    @PrimaryKey
    @SerializedName("title")
    @ColumnInfo(name = "id")
    var  id: String = " "

    @SerializedName("url")
    @ColumnInfo(name = "image")
    var url: String? = null

    @SerializedName("explanation")
    @ColumnInfo(name = "explanation")
    var explanation: String? = null

    @SerializedName("hdurl")
    @ColumnInfo(name = "hdimage")
    var hdurl: String? = null

    @SerializedName("date")
    @ColumnInfo(name = "date")
    var date: String? = null

    
}
