package com.urban.fresh.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.urban.fresh.R
import com.urban.fresh.Utils.AppConstants
import com.urban.fresh.model.DAOHomeDetails

class HomeCategoriesAdapter(
    var context: Context,
    var data: List<DAOHomeDetails.Component.Categorydata>
) :
    RecyclerView.Adapter<HomeCategoriesAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_categories, parent, false)
        return HomeViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        Glide.with(context)
            .load(AppConstants.BASE_URL + data[position].categoryPicture)
            .placeholder(R.drawable.ic_placeholder)
            .into(holder.ivCategoryImg)
        holder.tvCatName.text = data[position].categoryName
    }


    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivCategoryImg = itemView.findViewById<ImageView>(R.id.ivCategoryImg)
        var tvCatName = itemView.findViewById<TextView>(R.id.tvCatName)

    }
}