package com.example.ikhsanukk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class daftartugas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftartugas) // Pastikan file layout ini ada di res/layout

        // Referensi tombol dari layout XML
        val btnregister = findViewById<Button>(R.id.btn_register)

        // Logika tombol untuk berpindah halaman
        btnregister.setOnClickListener {
            // Pindah ke halaman isibukusatu
            val intent = Intent(this,  daftartugas::class.java)
            startActivity(intent)
        }
    }
}
