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
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.settings_lay_toolbar)
        toolbar.setNavigationOnClickListener {
            val backIntent = Intent(this@SettingsActivity, MainActivity::class.java)
            startActivity(backIntent)
        }

        val shareAppButton = findViewById<Button>(R.id.settings_lay_share_button)
        shareAppButton.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(
                Intent.EXTRA_TEXT,
                getString(R.string.practicum_developer_url)
            )
            startActivity(shareIntent)
        }

        val support = findViewById<Button>(R.id.settings_lay_write_to_support)
        support.setOnClickListener {
            val supportIntent = Intent(Intent.ACTION_SENDTO)
            supportIntent.data = Uri.parse("mailto:")
            supportIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(getString(R.string.email_send_to_address)))
            supportIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.email_content))
            supportIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject))
            startActivity(supportIntent)

        }


        val termOfUse = findViewById<Button>(R.id.settings_lay_term_of_use)
        termOfUse.setOnClickListener {
            val termOfUseIntent = Intent(Intent.ACTION_VIEW)
            termOfUseIntent.data = Uri.parse(getString(R.string.yandex_offer_url))
            startActivity(termOfUseIntent)
        }

    }
}