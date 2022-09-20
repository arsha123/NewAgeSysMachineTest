package com.example.newagesysmachinetest.utils

import com.example.newagesysmachinetest.Model.Model
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CATapi {
    @GET("?api_key=DEMO_KEY")
    fun getImgs(@Query("count") limit: Int): Call<List<Model>>
}