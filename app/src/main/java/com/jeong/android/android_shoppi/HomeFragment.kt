package com.jeong.android.android_shoppi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson
import org.json.JSONObject

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbarTitle = view.findViewById<TextView>(R.id.toolbar_home_title)
        val toolbarIcon = view.findViewById<ImageView>(R.id.toolbar_home_icon)
        val viewpager = view.findViewById<ViewPager2>(R.id.viewpage_home_banner)
        val viewpagerIndicator = view.findViewById<TabLayout>(R.id.viewpager_home_banner_indicator)

        val assetLoader = AssetLoader()
        val homeJsonString = assetLoader.getJsonString(requireContext(), "home.json")

        //homeData -> JsonObject
        if (!homeJsonString.isNullOrEmpty()) {
            val gson = Gson()
            val homeData = gson.fromJson(homeJsonString, HomeData::class.java)

            toolbarTitle.text = homeData.title.text
//            toolbarIcon.setImageResource(R.drawable.img_logo_home)
            // Glide를 이용해서 해당 Url 이미지로드하면 에러 발생 (실제기기에서만 에러 발생)
            GlideApp.with(this)
                .load(homeData.title.iconUrl)
                .into(toolbarIcon)

            viewpager.adapter = HomeBannerAdapter().apply {
                submitList(homeData.topBanners)
            }
            val pageWidth = resources.getDimension(R.dimen.viewpager_item_width)
            val pageMargin = resources.getDimension(R.dimen.viewpager_item_margin)
            val screenWidth = resources.displayMetrics.widthPixels
            val offset = screenWidth - pageWidth - pageMargin
            viewpager.offscreenPageLimit = 3
            viewpager.setPageTransformer { page, position ->
                page.translationX = position * -offset
            }
            TabLayoutMediator(viewpagerIndicator, viewpager) { tab, position ->

            }.attach()
        }
    }
}