package com.urban.fresh.network

interface ApiResponseHandler<T> {
    fun onResponse(response: T)
    fun onError(response: T) {}
}