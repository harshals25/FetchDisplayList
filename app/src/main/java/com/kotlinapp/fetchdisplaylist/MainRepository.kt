package com.kotlinapp.fetchdisplaylist

import com.kotlinapp.fetchdisplaylist.api.RetrofitClient
import com.kotlinapp.fetchdisplaylist.api.response.ListContent

class MainRepository {

    private val restClient = RetrofitClient.restClient

    // creating a suspend function so that it doesn't run on the Main Thread
    suspend fun getListFromAPI(): List<ListContent> {
        return restClient.getList()
    }
}