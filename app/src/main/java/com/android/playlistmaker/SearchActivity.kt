package com.android.playlistmaker

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SearchActivity : AppCompatActivity() {

    private var text: String = EMPTY_STRING

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)


        val backArrowButton = findViewById<Button>(R.id.search_lay_back_arrow)
        val clearIcon = findViewById<ImageView>(R.id.search_lay_clear_icon)
        val searchBar = findViewById<EditText>(R.id.search_lay_search_bar_edit_text)

        if (savedInstanceState != null) {
            searchBar.setText(text)
        }

        backArrowButton.setOnClickListener {
            val backArrowIntent = Intent(this, MainActivity::class.java)
            startActivity(backArrowIntent)
        }

        clearIcon.setOnClickListener {
            searchBar.setText("")
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager

            inputMethodManager?.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }


        val searchBarTextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                clearIcon.visibility = clearIconVisibility(s)
            }

            override fun afterTextChanged(s: Editable?) {
                text = s.toString()
            }

        }

        searchBar.addTextChangedListener(searchBarTextWatcher)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(SEARCH_BAR_TEXT, text)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        text = savedInstanceState.getString(SEARCH_BAR_TEXT, EMPTY_STRING)
    }


    private fun clearIconVisibility(c: CharSequence?): Int {
        return if (c.isNullOrEmpty()) {
            View.GONE
        } else {
            View.VISIBLE
        }
    }

    companion object {
        const val SEARCH_BAR_TEXT = "SEARCH_BAR_TEXT"
        const val EMPTY_STRING = ""
    }

}