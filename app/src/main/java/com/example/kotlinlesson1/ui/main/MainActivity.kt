package com.example.kotlinlesson1.ui.main

import android.os.Bundle
import android.provider.ContactsContract
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlinlesson1.NoteRVAdapter
import com.example.kotlinlesson1.R
import com.example.kotlinlesson1.ui.note.NoteActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var adapter: NoteRVAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // livedata.observe(this, Observer { Toast.makeText(this, it, Toast.LENGTH_SHORT).show() })
        rv_notes.layoutManager = GridLayoutManager(this, 2)

        adapter = NoteRVAdapter { note ->
            NoteActivity.start(this, note)
        }
        rv_notes.adapter = adapter
        viewModel.viewState().observe(this, Observer { it?.let { adapter.notes = it.notes } })

        btn_add_notes.setOnClickListener {
            NoteActivity.start(this)
        }

    }


}
