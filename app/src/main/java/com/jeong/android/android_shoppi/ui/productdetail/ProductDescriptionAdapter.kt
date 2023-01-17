package com.jeong.android.android_shoppi.ui.productdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jeong.android.android_shoppi.databinding.ItemProductDescriptionBinding
import com.jeong.android.android_shoppi.model.Description
import com.jeong.android.android_shoppi.model.Product

class ProductDescriptionAdapter : ListAdapter<Description, ProductDescriptionAdapter.DescriptionViewHolder>(DescriptionDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DescriptionViewHolder {
        val binding = ItemProductDescriptionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DescriptionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DescriptionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DescriptionViewHolder(private val binding : ItemProductDescriptionBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(description: Description) {
            binding.imageUrl = description.imageUrl
            binding.executePendingBindings()
        }
    }
}

class DescriptionDiffCallback : DiffUtil.ItemCallback<Description>() {
    override fun areItemsTheSame(oldItem: Description, newItem: Description): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Description, newItem: Description): Boolean {
        return oldItem == newItem
    }
}