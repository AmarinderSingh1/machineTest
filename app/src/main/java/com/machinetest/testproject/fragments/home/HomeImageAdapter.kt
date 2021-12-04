package com.machinetest.testproject.fragments.home

import android.content.Context
import androidx.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.machinetest.testproject.R
import com.machinetest.testproject.databinding.ItemHomeImageBinding

class HomeImageAdapter(
    val context: Context,
    val imageList: ArrayList<String>?
) : RecyclerView.Adapter<HomeImageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemHomeImageBinding>(
            LayoutInflater.from(context),
            R.layout.item_home_image,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(imageList?.get(position) ?: "")
    }

    override fun getItemCount(): Int {
        return imageList?.size ?: 0
    }

    class ViewHolder(itemView: ItemHomeImageBinding) : RecyclerView.ViewHolder(itemView.root) {
        var binding: ItemHomeImageBinding? = itemView

        fun bind(data: String) {
            binding?.imageData = data
            binding?.executePendingBindings()
        }
    }
}