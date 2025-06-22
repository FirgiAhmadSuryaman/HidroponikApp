package com.uti.hidroponikapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home_Activity : AppCompatActivity() {
    private lateinit var navigasiBawah: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        // Atur padding untuk sistem bar (status bar & navigation bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        navigasiBawah = findViewById(R.id.bottom_navigation)
        setupNavigasiBawah()

        // Tampilkan fragment home secara default
        if (savedInstanceState == null) {
            tampilkanFragmen(Home_Fragment())
        }
    }

    private fun setupNavigasiBawah() {
        navigasiBawah.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> tampilkanFragmen(Home_Fragment())
                R.id.nav_tanaman -> {
                     tampilkanFragmen(Tanaman_Fragment())
                    true
                }
                R.id.nav_chat -> {
                    // tampilkanFragmen(ChatFragment())
                    true
                }
                R.id.nav_toko -> {
                    // tampilkanFragmen(TokoFragment())
                    true
                }
                R.id.nav_tutorial -> {
                    // tampilkanFragmen(TutorialFragment())
                    true
                }
                else -> false
            }
        }

        navigasiBawah.selectedItemId = R.id.nav_home
    }

    private fun tampilkanFragmen(fragmen: Fragment): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragmen)
            .commit()
        return true
    }

    override fun onBackPressed() {
        val fragmenAktif = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (fragmenAktif is Home_Fragment) {
            super.onBackPressed()
        } else {
            navigasiBawah.selectedItemId = R.id.nav_home
        }
    }
}