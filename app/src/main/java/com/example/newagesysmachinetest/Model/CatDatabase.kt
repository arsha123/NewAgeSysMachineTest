package com.example.newagesysmachinetest.Model

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import androidx.sqlite.db.SupportSQLiteDatabase
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import androidx.sqlite.db.SupportSQLiteDatabase
//import com.example.mvvmroomcatapi.CatDatabase
import com.example.newagesysmachinetest.utils.catimgDao

@Database(entities = [Model::class], version = 5)
abstract class CatDatabase : RoomDatabase() {
    abstract fun catimgDao(): catimgDao
    internal class PopulateDbAsyn(catDatabase: CatDatabase?) : AsyncTask<Void?, Void?, Void?>() {
        private val catimgDao: catimgDao

        init {
            catimgDao = catDatabase!!.catimgDao()
        }

        override fun doInBackground(vararg voids: Void?): Void? {

            catimgDao.deleteAll()
            return null
        }
    }

    companion object {
        private const val DATABASE_NAME = "Cat"

        @Volatile
        var INSTANCE: CatDatabase? = null
        fun getInstance(context: Context?): CatDatabase? {
            if (INSTANCE == null) {
                synchronized(CatDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE =
                            Room.databaseBuilder(context!!, CatDatabase::class.java, DATABASE_NAME)
                                .fallbackToDestructiveMigration()
                                .addCallback(callback)
                                .build()
                    }
                }
            }
            return INSTANCE
        }

        var callback: Callback = object : Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                PopulateDbAsyn(INSTANCE)
            }
        }
    }
}