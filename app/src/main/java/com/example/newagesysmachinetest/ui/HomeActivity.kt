package com.example.newagesysmachinetest.ui

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newagesysmachinetest.Model.CatViewModel
import com.example.newagesysmachinetest.Model.Model
import com.example.newagesysmachinetest.R
import com.example.newagesysmachinetest.utils.CATapi
import com.example.newagesysmachinetest.utils.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeActivity : AppCompatActivity() {

    private lateinit var catViewModel: CatViewModel

    private lateinit var catAdapter: CatAdapter
    private lateinit var repository: Repository
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        val data = ArrayList<CatViewModel>()
        val getCats = ArrayList<Model>()

        repository = Repository(application)
        recyclerView.layoutManager = LinearLayoutManager(this)
        catViewModel = ViewModelProvider(this).get(CatViewModel::class.java)
        catAdapter = CatAdapter(this, getCats)
        makeRequest()
        catViewModel.allCats?.observe(this,
            Observer<List<Model?>?> { cats ->
                recyclerView.setAdapter(catAdapter)
                catAdapter!!.getAllDatas(cats as List<Model>)
                Log.d("main", "onChanged: $cats")
            })
    }

    private fun makeRequest() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/planetary/apod/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api: CATapi = retrofit.create(CATapi::class.java)
        val call: Call<List<Model>> = api.getImgs(10)
        call.enqueue(object : Callback<List<Model>> {
            override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>) {
                if (response.isSuccessful) {
                    val jsonData = response.body().toString()
                    Log.d("resend fcm", "onResponse: $jsonData")
                    repository?.insert(response.body())
                }            }

            override fun onFailure(call: Call<List<Model>>, t: Throwable) {
                Log.d("main", "onFailure: " + t.message)
            }
        })
    }
}