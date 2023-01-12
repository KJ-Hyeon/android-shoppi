package com.jeong.android.android_shoppi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jeong.android.android_shoppi.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation_main)
        // bottomNavigation의 컬러 참조를 초기화
        bottomNavigationView.itemIconTintList = null
        // bottomNavigatonView와 FragmentContainerView의 NavHostFragment를 연결

        val navController = supportFragmentManager.findFragmentById(R.id.container_main)?.findNavController()
        navController?.let {
            bottomNavigationView.setupWithNavController(it)
        }
    }
}