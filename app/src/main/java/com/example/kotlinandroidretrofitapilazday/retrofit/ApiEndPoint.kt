package com.example.kotlinandroidretrofitapilazday.retrofit

import com.example.kotlinandroidretrofitapilazday.MainModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoint {
    // ini untukInterface
    @GET("data.php")
    fun getData(): Call<MainModel>
}