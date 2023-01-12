package com.jeong.android.android_shoppi.ui.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.jeong.android.android_shoppi.GlideApp

// xml File에 쓸 커스텀 속성
@BindingAdapter("imageUrl")
fun loadImage(view : ImageView, imageUrl : String?) {
    // Glide를 이용해서 해당 Url 이미지로드하면 에러 발생 (실제기기에서만 에러 발생)
    if (!imageUrl.isNullOrEmpty()) {
        GlideApp.with(view)
            .load(imageUrl)
            .into(view)
    }
}
