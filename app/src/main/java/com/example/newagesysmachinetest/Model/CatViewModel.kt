package com.example.newagesysmachinetest.Model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.newagesysmachinetest.utils.Repository

class CatViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository
    var allCats: LiveData<List<Model?>?>?

    fun insert(cats: List<Model?>?) {
        repository.insert(cats)
    }



    init {
        repository = Repository(application)
        allCats = repository.allCats
    }
}