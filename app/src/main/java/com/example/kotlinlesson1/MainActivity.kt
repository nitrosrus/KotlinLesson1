package com.example.kotlinlesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        val livedata = viewModel.getViewStateLiveData()

        livedata.observe(this, Observer { Toast.makeText(this, it, Toast.LENGTH_SHORT).show() })

        livedata.observe(this, Observer { tv_counter.text=it })

        btn_next.setOnClickListener({ viewModel.updateCounter() })


    }

}
