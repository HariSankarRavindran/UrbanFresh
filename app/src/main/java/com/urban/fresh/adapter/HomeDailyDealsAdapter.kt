package com.urban.fresh.adapter

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.urban.fresh.R
import com.urban.fresh.model.DAODailyDeals

class HomeDailyDealsAdapter(
    var context: Context,
    var data: List<DAODailyDeals>,
    var type: Int
) :
    RecyclerView.Adapter<HomeDailyDealsAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_daily_deals, parent, false)
        return HomeViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        Glide.with(context)
            .load(data[position].image)
            .placeholder(R.drawable.ic_placeholder)
            .into(holder.ivDeals)
        holder.tvName.text = data[position].name
        holder.tvPrice.text = data[position].price
        if (type == 2) {
            holder.tvOfferPrice.visibility = View.GONE
        } else {
            holder.tvOfferPrice.apply {
                paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                text = data[position].offerPrice
            }
        }
    }

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivDeals: ImageView = itemView.findViewById<ImageView>(R.id.ivDeals)
        var tvName: TextView = itemView.findViewById<TextView>(R.id.tvName)
        var tvPrice: TextView = itemView.findViewById<TextView>(R.id.tvPrice)
        var tvOfferPrice: TextView = itemView.findViewById<TextView>(R.id.tvOfferPrice)

    }
}