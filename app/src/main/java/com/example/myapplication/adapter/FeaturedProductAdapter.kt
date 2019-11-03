package com.example.myapplication.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.FeaturedProductModel
import com.example.myapplication.model.HomeProductModel

class FeaturedProductAdapter(private val productList: ArrayList<FeaturedProductModel>) :
    RecyclerView.Adapter<FeaturedProductAdapter.FeaturedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeaturedViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.featured_item, parent, false)
        return FeaturedViewHolder(v)
    }

    override fun onBindViewHolder(holderLatest: FeaturedViewHolder, position: Int) {
        holderLatest.bindItems(productList[position])
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class FeaturedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(product: FeaturedProductModel) {
            val assured = itemView.findViewById(R.id.assured) as TextView
            val offer = itemView.findViewById(R.id.offer) as TextView
            val type = itemView.findViewById(R.id.type) as TextView
            val title = itemView.findViewById(R.id.title) as TextView
            val cutprice = itemView.findViewById(R.id.cutprice) as TextView
            val discount = itemView.findViewById(R.id.discount) as TextView
            val price = itemView.findViewById(R.id.price) as TextView
            val addCart = itemView.findViewById(R.id.addCart) as ImageView
            offer.text = itemView.context.getString(R.string.offer)+" "+product.discount.toString()+"%"
            type.text = product.brand
            title.text = product.title
            cutprice.text = itemView.context.getString(R.string.Rs) + product.cutPrice.toString()
            cutprice.setPaintFlags(cutprice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG)
            discount.text = product.discount.toString()
            price.text = itemView.context.getString(R.string.Rs) + product.price.toString()
            if(product.assured){
                assured.visibility = View.VISIBLE
            }else{
                assured.visibility = View.GONE
            }
            if(product.available){
                addCart.visibility = View.VISIBLE
            }else{
                addCart.visibility = View.GONE
            }
        }
    }
}