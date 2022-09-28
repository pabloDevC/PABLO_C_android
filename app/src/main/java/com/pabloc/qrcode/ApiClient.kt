package com.pabloc.qrcode

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

public class ApiClient {

    public var BASE_URL: String = "http://ec2-43-200-96-34.ap-northeast-2.compute.amazonaws.com:8080/"
    public var retrofit: Retrofit? = null

    public fun getApiClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit
    }

}