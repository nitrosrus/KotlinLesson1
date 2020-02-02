package com.example.kotlinlesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.GridLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var adapter: NoteRVAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // livedata.observe(this, Observer { Toast.makeText(this, it, Toast.LENGTH_SHORT).show() })
        rv_notes.layoutManager  = GridLayoutManager(this, 2)
        adapter = NoteRVAdapter()
        rv_notes.adapter = adapter
        viewModel.viewState().observe(this, Observer { it?.let { adapter.notes = it.notes } })

        btn_add_notes.setOnClickListener { add() }
    }
fun add(){
    viewModel.add("test","получилось или нет")
    viewModel.viewState().observe(this, Observer { it?.let { adapter.notes = it.notes } })
}
    fun duStuff() {}

}
