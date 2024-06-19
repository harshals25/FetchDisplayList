package com.kotlinapp.fetchdisplaylist.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClient {

    // This can be moved to a Constants file if required to keep the code more readable.
    // Leaving this here for now to keep things simple
    private const val BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val restClient : RestClient by lazy {
       retrofit.create(RestClient::class.java)
    }


}