package com.example.newagesysmachinetest.utils


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
import com.example.newagesysmachinetest.Model.Model

@Dao
interface catimgDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(cats: List<Model?>?)

    @Query("SELECT DISTINCT * FROM catimg")
    fun getcats(): LiveData<List<Model?>?>?

    @Query("DELETE FROM catimg")
    fun deleteAll()
}