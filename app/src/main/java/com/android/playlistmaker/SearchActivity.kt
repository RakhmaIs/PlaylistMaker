package com.android.playlistmaker

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val clearIcon = findViewById<ImageView>(R.id.search_lay_clear_icon)
        val searchBar = findViewById<EditText>(R.id.search_lay_search_bar_edit_text)

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

            }

        }

        searchBar.addTextChangedListener(searchBarTextWatcher)
    }


    private fun clearIconVisibility(c: CharSequence?): Int {
        return if (c.isNullOrEmpty()) {
            View.GONE
        } else {
            View.VISIBLE
        }
    }

}