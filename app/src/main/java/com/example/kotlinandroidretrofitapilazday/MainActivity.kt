 package com.example.kotlinandroidretrofitapilazday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlinandroidretrofitapilazday.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

 class MainActivity : AppCompatActivity() {
    private val TAG: String = "MainActivity" // <- untuk memfilter saat di debug// untuk buat logcat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        getDataFromApi()
    }

    private fun getDataFromApi(){
        ApiService.endPoint.getData()
                .enqueue(object : Callback <MainModel> {
                    override fun onResponse(call: Call <MainModel>, response: Response <MainModel>) {
                        showData( response.body()!! )
                    }

                    override fun onFailure(call: Call<MainModel>, t: Throwable) {
                        printLog(t.toString())
                    }
                })
    }

    // hasilnya akan menggunakan logcat
    private fun printLog(massage: String){
        Log.d(TAG, massage) // d artinya log akan ditampilkan di debug
    }

     //Merapikan hasil di debug
     private fun showData(data: MainModel){
         val results = data.result
         for (result in results) { // Loop, photo digunakan untuk mengambil setiap 1 gambar di setiap photos
             printLog(" title : ${result.title}")
         }
     }
}