package com.android.playlistmaker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_settings)
        val backArrowButton = findViewById<Button>(R.id.back_arrow)
        backArrowButton.setOnClickListener {
            val backIntent = Intent(this@SettingsActivity, MainActivity::class.java)
            startActivity(backIntent)
        }
    }
}