 package com.example.kotlinandroidretrofitapilazday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinandroidretrofitapilazday.retrofit.ApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

 class MainActivity : AppCompatActivity() {
    private val TAG: String = "MainActivity" // <- untuk memfilter saat di debug// untuk buat logcat



     lateinit var mainAdapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        setupRecyclerView()
        getDataFromApi()
    }

     private fun setupRecyclerView(){
         mainAdapter = MainAdapter(arrayListOf()) // disini hanya butuh data Array, array list of disini belum ada datanya
         recyclerView.apply {
             layoutManager = LinearLayoutManager(applicationContext)
             adapter = mainAdapter
         }
     }

    private fun getDataFromApi(){
        progressBar.visibility = View.VISIBLE
        ApiService.endPoint.getData()
                .enqueue(object : Callback <MainModel> {
                    override fun onResponse(call: Call <MainModel>, response: Response <MainModel>) {
                        progressBar.visibility = View.GONE
                        showData( response.body()!! )
                    }

                    override fun onFailure(call: Call<MainModel>, t: Throwable) {
                        progressBar.visibility = View.GONE
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
         mainAdapter.setData( results )
         for (result in results) { // Loop, photo digunakan untuk mengambil setiap 1 gambar di setiap photos
             printLog(" title : ${result.title}")
         }
     }

}