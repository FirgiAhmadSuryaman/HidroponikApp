package com.uti.hidroponikapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

//        val usernameEditText = findViewById<EditText>(R.id.etUsername)
//        val passwordEditText = findViewById<EditText>(R.id.etPassword)
//        val loginButton = findViewById<Button>(R.id.btnLogin)
//
//        loginButton.setOnClickListener {
//            val username = usernameEditText.text.toString().trim()
//            val password = passwordEditText.text.toString().trim()
//
//            if (username.isEmpty()) {
//                Toast.makeText(this, "Username tidak boleh kosong", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//
//            if (password.isEmpty()) {
//                Toast.makeText(this, "Password tidak boleh kosong", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//
//            if (password.length < 6) {
//                Toast.makeText(this, "Password minimal 6 karakter", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//
//            // Jika semua valid
//            Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()
//
//            // TODO: Pindah ke halaman berikutnya (main menu, dll)
//        }
//    }
}}
