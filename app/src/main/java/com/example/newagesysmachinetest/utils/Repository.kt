package com.example.newagesysmachinetest.utils

import android.app.Application
import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.newagesysmachinetest.Model.CatDatabase
import com.example.newagesysmachinetest.Model.Model

class Repository(application: Application?) {
    var catimgDao: catimgDao?
    var allCats: LiveData<List<Model?>?>?
    private val database: CatDatabase?
    fun insert(cats: List<Model?>?) {
        InsertAsyncTask(catimgDao).execute(cats)
    }

    private class InsertAsyncTask(private val catimgDao: catimgDao?) :
        AsyncTask<List<Model?>?, Void?, Void?>() {
        @SafeVarargs


        override fun doInBackground(vararg lists: List<Model?>?): Void? {
            Log.d("arshs", "doInBackground: " + lists[0])
            catimgDao!!.insert(lists[0])
            return null
        }
    }

    init {
        database = CatDatabase.Companion.getInstance(application)
        catimgDao = database!!.catimgDao()
        allCats = catimgDao!!.getcats()
    }
}