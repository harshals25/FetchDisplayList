package com.kotlinapp.fetchdisplaylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListAdapter
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kotlinapp.fetchdisplaylist.adapter.ListXMLAdapter
import com.kotlinapp.fetchdisplaylist.databinding.ActivityKotlinXmlactivityBinding

class KotlinXMLActivity : AppCompatActivity() {


    private lateinit var binding: ActivityKotlinXmlactivityBinding
    private val viewModel: MainViewModel by viewModels()

    private lateinit var adapter: ListXMLAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKotlinXmlactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // initializing with an empty list
        adapter = ListXMLAdapter(emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.itemListForXML.observe(this) { items ->
            // updating the recyclerview based on returns
            binding.recyclerView.visibility = View.VISIBLE
            adapter.updateItems(items)
        }

        viewModel.errorMessageForXML.observe(this) { message ->
            // showing error in case the API fails
            binding.errorTextView.text = message ?: "Unknown error"
        }
    }
}