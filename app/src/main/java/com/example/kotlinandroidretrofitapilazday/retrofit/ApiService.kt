package com.example.kotlinandroidretrofitapilazday.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiService {

    val BASE_URL: String = "https://jsonplaceholder.typicode.com/"
    val endPoint: ApiEndPoint //diambil dari class ApiEndPoint
        get() {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory)
                .build()

            return retrofit.create(ApiEndPoint::class.java)
        }

}