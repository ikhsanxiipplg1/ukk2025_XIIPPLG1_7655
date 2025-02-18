package com.example.ikhsanukk

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge layout (removes status bar and makes the content fill the screen)
        enableEdgeToEdge()

        // Set the content view to the activity_main layout
        setContentView(R.layout.activity_main)

        // Apply window insets to avoid content overlapping system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // You can set up the button click listener here
        findViewById<button>(R.id.button).setOnClickListener {
            // Handle button click here
        }
    }

    // Function to enable edge-to-edge layout
    private fun enableEdgeToEdge() {
        // Make the status bar and navigation bar transparent, enabling full-screen experience
        window.decorView.systemUiVisibility = (
                android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                        android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                )
        window.statusBarColor = android.graphics.Color.TRANSPARENT // Set the status bar color to transparent
    }
}