package com.urban.fresh.model

import com.urban.fresh.R
import java.util.*

data class DAODailyDeals(
    var image: Int,
    var name: String,
    var price: String,
    var offerPrice: String,
    var currency: String
)

fun loadDailyDeals(): MutableList<DAODailyDeals> {
    val listItems: MutableList<DAODailyDeals> = ArrayList()
    val daoDailyDeals = DAODailyDeals(R.drawable.image1, "Brinjal", "15.00", "12.00", "₹")
    listItems.add(0, daoDailyDeals)
    val daoDailyDeals1 = DAODailyDeals(R.drawable.image2, "Potato", "17.00", "15.00", "₹")
    listItems.add(1, daoDailyDeals1)
    val daoDailyDeals2 = DAODailyDeals(R.drawable.image3, "Onion", "19.00", "17.00", "₹")
    listItems.add(2, daoDailyDeals2)
    val daoDailyDeals3 = DAODailyDeals(R.drawable.image4, "Tomato", "21.00", "19.00", "₹")
    listItems.add(3, daoDailyDeals3)
    val daoDailyDeals4 = DAODailyDeals(R.drawable.image5, "Spinach", "23.00", "18.00", "₹")
    listItems.add(4, daoDailyDeals4)
    val daoDailyDeals5 = DAODailyDeals(R.drawable.image6, "Mushroom", "25.00", "21.00", "₹")
    listItems.add(5, daoDailyDeals5)
    return listItems
}

fun loadNewArrivals(): MutableList<DAODailyDeals> {
    val listItems = ArrayList<DAODailyDeals>()
    val daoDailyDeals = DAODailyDeals(R.drawable.image2, "Brinjal", "15.00", "12.00", "₹")
    listItems.add(0, daoDailyDeals)
    val daoDailyDeals1 = DAODailyDeals(R.drawable.image3, "Potato", "17.00", "15.00", "₹")
    listItems.add(1, daoDailyDeals1)
    val daoDailyDeals2 = DAODailyDeals(R.drawable.image4, "Onion", "19.00", "17.00", "₹")
    listItems.add(2, daoDailyDeals2)
    val daoDailyDeals3 = DAODailyDeals(R.drawable.image5, "Tomato", "21.00", "19.00", "₹")
    listItems.add(3, daoDailyDeals3)
    val daoDailyDeals4 = DAODailyDeals(R.drawable.image6, "Spinach", "23.00", "18.00", "₹")
    listItems.add(4, daoDailyDeals4)
    val daoDailyDeals5 = DAODailyDeals(R.drawable.image7, "Mushroom", "25.00", "21.00", "₹")
    listItems.add(5, daoDailyDeals5)
    return listItems
}

