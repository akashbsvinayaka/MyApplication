package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.LatestProductModel

class LatestProductsAdapter(private val productList: ArrayList<LatestProductModel>) : RecyclerView.Adapter<LatestProductsAdapter.LatestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.latest_item, parent, false)
        return LatestViewHolder(v)
    }

    override fun onBindViewHolder(holderLatest: LatestViewHolder, position: Int) {
        holderLatest.bindItems(productList[position])
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class LatestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(product: LatestProductModel) {
            val type = itemView.findViewById(R.id.type) as TextView
            val title  = itemView.findViewById(R.id.title)as TextView
            val price  = itemView.findViewById(R.id.price)as TextView
            type.text = product.type
            title.text = product.title
            price.text =itemView.context.getString(R.string.Rs)+product.price.toString()
        }
    }
}