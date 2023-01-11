package com.jeong.android.android_shoppi

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter

class HomeBannerAdapter : ListAdapter<Banner, HomeBannerAdapter.HomerBannerViewHolder>(BannerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomerBannerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_banner, parent, false)
        return HomerBannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomerBannerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class HomerBannerViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        private val bannerImageView = view.findViewById<ImageView>(R.id.iv_banner_image)
        private val bannerBadgeTextView = view.findViewById<TextView>(R.id.tv_banner_badge)
        private val bannerTitleTextView = view.findViewById<TextView>(R.id.tv_banner_title)
        private val bannerDetailThumbnailImageView = view.findViewById<ImageView>(R.id.iv_banner_detail_thumbnail)
        private val bannerDetailBrandLabelTextView = view.findViewById<TextView>(R.id.tv_banner_detail_brand_label)
        private val bannerDetailProductLabelTextView = view.findViewById<TextView>(R.id.tv_banner_detail_product_label)
        private val bannerDetailDiscountRateTextView = view.findViewById<TextView>(R.id.tv_banner_detail_product_discount_rate)
        private val bannerDetailDiscountPriceTextView = view.findViewById<TextView>(R.id.tv_banner_detail_product_price)
        private val bannerDetailProductPriceTextView = view.findViewById<TextView>(R.id.tv_banner_detail_product_price)

        fun bind(banner: Banner) {
            GlideApp.with(itemView)
                .load(banner.backgroundImageUrl)
                .into(bannerImageView)
        }
    }
}

class BannerDiffCallback : DiffUtil.ItemCallback<Banner>() {
    override fun areItemsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem.productDetail.productId == newItem.productDetail.productId
    }

    override fun areContentsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem == newItem
    }

}