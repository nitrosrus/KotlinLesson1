package com.example.kotlinlesson1.ui.main

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlinlesson1.R
import com.example.kotlinlesson1.data.entity.Note
import com.example.kotlinlesson1.ui.base.BaseActivity
import com.example.kotlinlesson1.ui.note.NoteActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<List<Note>?, MainViewState>() {

    override val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }
    override val layoutRes = R.layout.activity_main
    lateinit var adapter: NoteRVAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        rv_notes.layoutManager = GridLayoutManager(this, 2)
        adapter = NoteRVAdapter { note ->
            NoteActivity.start(this, note)
        }
        rv_notes.adapter = adapter

        btn_add_notes.setOnClickListener {
            NoteActivity.start(this)
        }

    }


    override fun renderData(data: List<Note>?) {
        data?.let {
            adapter.notes = it
        }
    }

}
