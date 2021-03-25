package com.urban.fresh.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.urban.fresh.R
import com.urban.fresh.Utils.AppConstants
import com.urban.fresh.model.DAOHomeDetails

class HomeAdsBannerAdapter(
    var context: Context,
    var data: List<DAOHomeDetails.Component.AdsBanner>
) :
    RecyclerView.Adapter<HomeAdsBannerAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_ads, parent, false)
        return HomeViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        Glide.with(context)
            .load(AppConstants.BASE_URL + data[position].bannerImage)
            .placeholder(R.drawable.ic_placeholder_banner)
            .into(holder.ivHomeBanner)
    }


    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivHomeBanner = itemView.findViewById<ImageView>(R.id.ivHomeBanner)

    }
}