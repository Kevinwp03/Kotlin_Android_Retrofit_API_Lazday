package com.example.kotlinandroidretrofitapilazday.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiService {

    val BASE_URL: String = "https://demo.lazday.com/rest-api-sample/"
    val endPoint: ApiEndPoint //diambil dari class ApiEndPoint
        get() {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiEndPoint::class.java)
        }

}