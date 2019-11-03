package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.HomeProductModel
import com.example.myapplication.model.LatestProductModel

class HomeProductsAdapter(private val productList: ArrayList<HomeProductModel>) : RecyclerView.Adapter<HomeProductsAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.home_item, parent, false)
        return HomeViewHolder(v)
    }

    override fun onBindViewHolder(holderLatest: HomeViewHolder, position: Int) {
        holderLatest.bindItems(productList[position])
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(product: HomeProductModel) {
            val title1  = itemView.findViewById(R.id.title1)as TextView
            val title2  = itemView.findViewById(R.id.title2)as TextView
            val title3  = itemView.findViewById(R.id.title3)as TextView
            title1.text = product.title1
            title2.text = product.title2
            title3.text = product.title3
        }
    }
}