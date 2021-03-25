package com.urban.fresh.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {

    @POST("home_test_section")
    fun fetchHomeDetails(@Query("category_id") category_id: String): Call<ResponseBody>


}