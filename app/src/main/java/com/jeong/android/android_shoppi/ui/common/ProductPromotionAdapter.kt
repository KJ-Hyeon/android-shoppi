package com.jeong.android.android_shoppi.ui.categorydetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jeong.android.android_shoppi.databinding.ItemCategoryPromotionBinding
import com.jeong.android.android_shoppi.model.Product
import com.jeong.android.android_shoppi.ui.common.ProductClickListener

class ProductPromotionAdapter(private val clickListener : ProductClickListener): ListAdapter<Product, ProductPromotionAdapter.PromotionViewHolder>(ProductDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromotionViewHolder {
        val binding = ItemCategoryPromotionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PromotionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PromotionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class PromotionViewHolder(private val binding: ItemCategoryPromotionBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(product : Product) {
            binding.product = product
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }
}

class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.productId == newItem.productId
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }

}