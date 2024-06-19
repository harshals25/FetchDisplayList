package com.kotlinapp.fetchdisplaylist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlinapp.fetchdisplaylist.api.RetrofitClient
import com.kotlinapp.fetchdisplaylist.api.response.ListContent
import kotlinx.coroutines.*

class MainViewModel : ViewModel() {


    private val repository = MainRepository()

    // used when we are using compose
    val itemList : MutableState<List<ListContent>> = mutableStateOf(emptyList())
    val errorMessage: MutableState<String?> = mutableStateOf(null)

    // using separate variables so that its more readable, these are being used when we use XML Views
    private val _itemList: MutableLiveData<List<ListContent>> = MutableLiveData()
    val itemListForXML: LiveData<List<ListContent>> = _itemList

    private val _errorMessage: MutableLiveData<String?> = MutableLiveData()
    val errorMessageForXML: LiveData<String?> = _errorMessage

    // initializing the call
    init {
        getList()
    }

    private fun getList(){
        viewModelScope.launch {
            try{
                // initializing the call
                val response = repository.getListFromAPI()
                if(response.isNotEmpty()) {
                    // filtering based on listId first and then on name, also removing blank and nulls
                    // assumption - Name is always ITEM XYZ and XYZ is an integer
                    // need to change this logic if the API response changes.
                    val filteredItems = response.filter { it.name?.isNotBlank() ?: false }
                        .sortedWith(compareBy(
                            { it.listId ?: Int.MAX_VALUE },
                            { it.name?.split(" ")?.get(1)?.toInt() }
                        ))

                    // putting filtered values in the respective objetcs
                    itemList.value = filteredItems
                    _itemList.value = filteredItems
                }
            }
            catch (e:Exception){

                // error handling - can be made more user friendly as required
                errorMessage.value = e.localizedMessage ?: "Unknown error"
                _errorMessage.value = e.localizedMessage ?: "Unknown error"
            }
        }
    }

}