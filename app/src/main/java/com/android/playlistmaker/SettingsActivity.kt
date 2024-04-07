package com.android.playlistmaker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val backArrowButton = findViewById<Button>(R.id.back_arrow_settings)
        backArrowButton.setOnClickListener {
            val backIntent = Intent(this@SettingsActivity, MainActivity::class.java)
            startActivity(backIntent)
        }

        val shareAppButton = findViewById<Button>(R.id.share_button)
        shareAppButton.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(
                Intent.EXTRA_TEXT,
                "https://practicum.yandex.ru/profile/android-developer/"
            )
            startActivity(shareIntent)
        }

        val support = findViewById<Button>(R.id.write_to_support)
        support.setOnClickListener {
            val message = "Спасибо разработчикам и разработчицам за крутое приложение!"
            val subject = "Сообщение разработчикам и разработчицам приложения Playlist Maker"
            val email = "bigshomas@yandex.ru"
            val supportIntent = Intent(Intent.ACTION_SENDTO)
            supportIntent.data = Uri.parse("mailto:")
            supportIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
            supportIntent.putExtra(Intent.EXTRA_TEXT, message)
            supportIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
            startActivity(supportIntent)

        }


        val termOfUse = findViewById<Button>(R.id.term_of_use)
        termOfUse.setOnClickListener {
            val termOfUseIntent = Intent(Intent.ACTION_VIEW)
            termOfUseIntent.data = Uri.parse("https://yandex.ru/legal/practicum_offer/")
            startActivity(termOfUseIntent)
        }

    }
}