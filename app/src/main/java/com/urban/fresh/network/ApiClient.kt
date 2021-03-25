package com.urban.fresh.network

import android.app.Activity
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.urban.fresh.Utils.AppConstants
import com.urban.fresh.Utils.ProgressDlg
import com.urban.fresh.Utils.isNetworkAvailable
import com.urban.fresh.Utils.toast
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    var apiInterface: ApiInterface? = null

    val client: ApiInterface
        get() {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().callTimeout(1000, TimeUnit.MILLISECONDS)
                .connectTimeout(1000, TimeUnit.MILLISECONDS)
                .readTimeout(1000, TimeUnit.MILLISECONDS)
                .writeTimeout(1000, TimeUnit.MILLISECONDS).retryOnConnectionFailure(true)
                .addInterceptor(interceptor).build()
            if (apiInterface == null) {
                val gSonBuilder = GsonBuilder().setLenient().create()

                apiInterface = Retrofit.Builder().baseUrl(AppConstants.API_URL)
                    .addConverterFactory(GsonConverterFactory.create(gSonBuilder)).client(client)
                    .build().create(ApiInterface::class.java)
            }
            return apiInterface!!
        }

    fun <T> Call<ResponseBody>.publish(
        context: Activity,
        classType: Class<T>,
        responseHandler: ApiResponseHandler<T>,
        showing: Boolean
    ) {

        if (context.isNetworkAvailable()) {
            if (showing) ProgressDlg.showProgressDialog(context, null, null)

            enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    ProgressDlg.dismissProgressDialog()
                }

                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    ProgressDlg.dismissProgressDialog()
                    response.body()?.string()?.let { successJson ->
                        try {
                            val jsonObj = JSONObject(successJson)
                            if (jsonObj.getBoolean("success") == AppConstants.SUCCESS) {
                                val successModel = Gson().fromJson(successJson, classType)
                                responseHandler.onResponse(successModel)
                            } else if (jsonObj.getBoolean("success") == AppConstants.FAILURE) {
                                val successModel = Gson().fromJson(successJson, classType)
                                context.toast("Response Error")
                                responseHandler.onError(successModel)
                            } else {
                                context.toast("Response Error")
                            }
                        } catch (e: Exception) {
                            Log.d("exception", "" + e.message)
                        }
                    }
                }
            })
        } else {
            context.toast(
                "Internet not available, Cross check your internet connectivity and try again"
            )
        }
    }

}