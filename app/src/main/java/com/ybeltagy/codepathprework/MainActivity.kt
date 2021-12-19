package com.ybeltagy.codepathprework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.apache.commons.io.FileUtils
import java.io.File
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    private var list = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize list
        loadItems()

        // Initialize the recycler view
        val recyclerView = findViewById<RecyclerView>(R.id.todolist_recyclerview)

        lateinit var adapter : ItemAdapter
        val clickListener = object : ItemAdapter.ItemEventListener{
            override fun onItemDeleteRequest(position: Int) {
                list.removeAt(position)
                adapter.notifyDataSetChanged()
                saveItems()
            }

            val editItemActivityLauncher = registerForActivityResult(
                ActivityResultContracts.StartActivityForResult()
            ) { result: ActivityResult? ->
                if (result?.resultCode == RESULT_OK) {
                    val bundle = result.data?.extras
                    val id = bundle?.getInt("id")
                    val item = bundle?.getString("value")

                    with(receiver = adapter) {
                        if (id != null && item != null && id >= 0 && id < list.size) {
                            list[id] = item
                        }

                        notifyDataSetChanged()
                    }

                    saveItems()
                }

            }

            override fun onItemEditRequest(position: Int) {
                val intent = Intent(this@MainActivity, EditItemActivity::class.java)
                intent.putExtra("id", position)
                intent.putExtra("value", list[position])
                editItemActivityLauncher.launch(intent)
            }

        }

        adapter = ItemAdapter(list, clickListener)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize the add button
        val addEditText = findViewById<EditText>(R.id.add_edittext)
        findViewById<Button>(R.id.add_button).setOnClickListener {

            val string = addEditText.text.toString().trim()

            if(!string.isEmpty()){
                list.add(string)

                adapter.notifyItemInserted(list.size - 1)

                saveItems()

                addEditText.setText("")
            }
        }
    }

    private fun getDataFile() : File {
        return File(filesDir, "data.txt")
    }

    fun saveItems(){
        try {
            FileUtils.writeLines(getDataFile(), list)
        } catch (ioException :IOException){
            ioException.printStackTrace()
        }
    }

    private fun loadItems(){
        try {
            list = FileUtils.readLines(getDataFile(), Charset.defaultCharset())
        } catch (ioException :IOException){
            ioException.printStackTrace()
        }
    }
}