package com.urban.fresh

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.urban.fresh.adapter.HomeAdsBannerAdapter
import com.urban.fresh.adapter.HomeBannerAdapter
import com.urban.fresh.adapter.HomeCategoriesAdapter
import com.urban.fresh.adapter.HomeDailyDealsAdapter
import com.urban.fresh.model.DAOHomeDetails
import com.urban.fresh.model.loadDailyDeals
import com.urban.fresh.model.loadNewArrivals
import com.urban.fresh.network.ApiClient
import com.urban.fresh.network.ApiClient.publish
import com.urban.fresh.network.ApiResponseHandler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        fetchHomeDetails()
    }

    fun initViews() {
        tvDailyDeals.visibility = View.VISIBLE
        rvDailyDeals.visibility = View.VISIBLE
        rvDailyDeals.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvDailyDeals.adapter = HomeDailyDealsAdapter(this, loadDailyDeals(), 1)

        tvNewArrivals.visibility = View.VISIBLE
        rvNewArrivals.visibility = View.VISIBLE
        rvNewArrivals.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvNewArrivals.adapter = HomeDailyDealsAdapter(this, loadNewArrivals(), 2)
    }

    fun fetchHomeDetails() {
        ApiClient.client.fetchHomeDetails("2")
            .publish(
                this,
                DAOHomeDetails::class.java,
                object : ApiResponseHandler<DAOHomeDetails> {
                    override fun onResponse(response: DAOHomeDetails) {
                        response.components.forEach {
                            if (it.name == "StaticBanner") {
                                if (it.staticBanner.isNotEmpty()) {
                                    rvHomeBanner.visibility = View.VISIBLE
                                    rvHomeBanner.layoutManager =
                                        LinearLayoutManager(
                                            this@MainActivity,
                                            LinearLayoutManager.HORIZONTAL,
                                            false
                                        )
                                    rvHomeBanner.adapter =
                                        HomeBannerAdapter(this@MainActivity, it.staticBanner)
                                }
                            } else if (it.name == "MainCategories") {
                                if (it.categorydata.isNotEmpty()) {
                                    rvCategories.visibility = View.VISIBLE
                                    llCategories.visibility = View.VISIBLE
                                    rvCategories.layoutManager =
                                        GridLayoutManager(this@MainActivity, 3)
                                    rvCategories.adapter =
                                        HomeCategoriesAdapter(this@MainActivity, it.categorydata)
                                }
                            } else if (it.name == "AdsBanner") {
                                if (it.adsBanner.isNotEmpty()) {
                                    rvAds.visibility = View.VISIBLE
                                    rvAds.layoutManager = LinearLayoutManager(
                                        this@MainActivity,
                                        LinearLayoutManager.HORIZONTAL,
                                        false
                                    )
                                    rvAds.adapter =
                                        HomeAdsBannerAdapter(this@MainActivity, it.adsBanner)

                                    rvAds2.visibility = View.VISIBLE
                                    rvAds2.layoutManager = LinearLayoutManager(
                                        this@MainActivity,
                                        LinearLayoutManager.HORIZONTAL,
                                        false
                                    )
                                    rvAds2.adapter =
                                        HomeAdsBannerAdapter(this@MainActivity, it.adsBanner)
                                }
                            }
                        }
                    }
                },
                true
            )
    }

}