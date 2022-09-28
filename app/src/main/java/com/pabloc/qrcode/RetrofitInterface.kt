package com.pabloc.qrcode

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("OrderData")
    fun requestAllData() : Call<OrderData>
}