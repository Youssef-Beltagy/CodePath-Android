package com.ybeltagy.codepathprework

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditItemActivity: AppCompatActivity() {

    var id : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_item)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);

        id = intent.getIntExtra("id", -1)
        val value = intent.getStringExtra("value")

        val temp = findViewById<EditText>(R.id.edit_editText).setText(value)

    }

    fun onSave(v: View) {
        val value = findViewById<EditText>(R.id.edit_editText).text.toString().trim()

        val data = Intent()
        data.putExtra("id", id)
        data.putExtra("value", value)

        // Activity finished ok, return the data
        setResult(RESULT_OK, data) // set result code and bundle data for response
        finish() // closes the activity, pass data to parent
    }
}