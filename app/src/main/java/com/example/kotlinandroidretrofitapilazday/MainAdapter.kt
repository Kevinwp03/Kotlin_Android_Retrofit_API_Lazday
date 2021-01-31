package com.example.kotlinandroidretrofitapilazday

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_main.view.*

class MainAdapter(val results: ArrayList<MainModel.Result>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() { //isi contstracnya di parameter
    // Implement Member
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder ( // mengganti ":" menjadi "=" sehingga tidak perlu menulis return
        LayoutInflater.from(parent.context).inflate( R.layout.adapter_main, parent, false)
    )
    override fun onBindViewHolder(holder: ViewHolder, position: Int) { // parsing data, ke layout,
        val result = results[position]              // gunakan ini, jika ada banyak data yg akan di ambil
        holder.view.textView.text = result.title
    }

    override fun getItemCount() = results.size

    class ViewHolder (val view: View) : RecyclerView.ViewHolder(view) // extennya diparameter

    fun setData(data: List<MainModel.Result>){ // ini akan di kasih masuk di MainActivity->showData
        results.clear()         //data akan di hapus jika masih ada data
        results.addAll( data )  //Menambahkan data
        notifyDataSetChanged()  //Refresh data Recycler viewnya
    }
}