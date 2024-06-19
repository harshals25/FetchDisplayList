package com.kotlinapp.fetchdisplaylist.api

import com.kotlinapp.fetchdisplaylist.api.response.ListContent
import retrofit2.http.GET

interface RestClient {

    // we can add more APIs here as needed
    @GET("hiring.json")
    suspend fun getList() : List<ListContent>
}