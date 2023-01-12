package com.jeong.android.android_shoppi.ui.common

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import androidx.databinding.BindingConversion

// 데이터 바인딩 표현식에 할당된 값의 Type을 변환하는 방법을 정의
@BindingConversion
fun convertToColorDrawable(color : String) : Drawable {
    return ColorDrawable(Color.parseColor(color))
}