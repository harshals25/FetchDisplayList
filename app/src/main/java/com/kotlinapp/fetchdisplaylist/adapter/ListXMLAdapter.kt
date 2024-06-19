package com.kotlinapp.fetchdisplaylist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kotlinapp.fetchdisplaylist.api.response.ListContent
import com.kotlinapp.fetchdisplaylist.databinding.RecyclerviewListItemBinding


class ListXMLAdapter(private var items: List<ListContent>) : RecyclerView.Adapter<ListXMLAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = RecyclerviewListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }


    // updating the items when we get them from our viewModel
    fun updateItems(newItems: List<ListContent>) {
        items = newItems
        notifyDataSetChanged()
    }

    // displaying items in the list
    class ListViewHolder(private val binding: RecyclerviewListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ListContent) {
            binding.tvItemListId.text = "List Id -> ${item.listId}"
            binding.tvItemName.text = "Name -> ${item.name}"
        }
    }
}
