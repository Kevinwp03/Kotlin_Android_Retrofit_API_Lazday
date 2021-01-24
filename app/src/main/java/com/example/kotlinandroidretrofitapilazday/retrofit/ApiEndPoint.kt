package com.example.kotlinandroidretrofitapilazday.retrofit

import retrofit2.http.GET

interface ApiEndPoint {
    // ini untukInterface
    @GET("photos")
    fun getPhotos()
}