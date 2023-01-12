package com.jeong.android.android_shoppi.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

// 스플래시 화면은 layout을 통해서 만들지 않고 drawable을 통해서 구현 -> API30이하 버전에서 실행
class SplashActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}