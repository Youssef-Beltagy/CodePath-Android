package com.ybeltagy.codepathprework

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditItemActivity: AppCompatActivity() {

    private var id : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_item)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        id = intent.getIntExtra("id", -1)
        val value = intent.getStringExtra("value")

        findViewById<EditText>(R.id.edit_editText).setText(value)

        findViewById<Button>(R.id.save_button).setOnClickListener {
            val string = findViewById<EditText>(R.id.edit_editText).text.toString().trim()

            val data = Intent()
            data.putExtra("id", id)
            data.putExtra("value", string)

            // Activity finished ok, return the data
            setResult(RESULT_OK, data) // set result code and bundle data for response
            finish() // closes the activity, pass data to parent
        }

    }

}