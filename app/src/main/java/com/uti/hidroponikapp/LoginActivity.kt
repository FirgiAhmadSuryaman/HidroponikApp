package com.uti.hidroponikapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val tombolMasuk = findViewById<Button>(R.id.btn_login)
        val teksDaftar = findViewById<TextView>(R.id.tv_register)

        tombolMasuk.setOnClickListener {
            // Berpindah ke BerandaActivity
            val intent = Intent(this, Home_Activity::class.java)
            startActivity(intent)
            finish() // Opsional: agar LoginActivity tidak bisa diakses kembali dengan tombol back
        }


    }

}
