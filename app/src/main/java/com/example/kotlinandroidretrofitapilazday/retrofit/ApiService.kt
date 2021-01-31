package com.example.kotlinandroidretrofitapilazday.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiService {

    val BASE_URL: String = "https://demo.lazday.com/rest-api-sample/"
    val endPoint: ApiEndPoint //diambil dari class ApiEndPoint
        get() {
            //
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            //buat clientnya
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

            //
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client) // paggil cliennya, setelah BaseUrl
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiEndPoint::class.java)
        }

}