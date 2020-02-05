package com.example.kotlinlesson1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var IntX = 0
    private val text = "click on btn"
    private val viewStateLiveData: MutableLiveData<String> = MutableLiveData()

    init {
        viewStateLiveData.value = text + " " + IntX
    }

    fun getViewStateLiveData(): LiveData<String> {
        return viewStateLiveData
    }

    fun counterText(): String {
        IntX++
        var newText = text + " " + IntX
        return newText
    }

    fun updateCounter() {

        viewStateLiveData.setValue(counterText())
    }
}