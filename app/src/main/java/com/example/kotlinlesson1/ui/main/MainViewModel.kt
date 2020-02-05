package com.example.kotlinlesson1.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinlesson1.data.NotesRepository

class MainViewModel : ViewModel() {
    private val viewStateLiveData: MutableLiveData<MainViewState> = MutableLiveData()

    init {
        NotesRepository.getNotes().observeForever {
            viewStateLiveData.value =
                viewStateLiveData.value?.copy(notes = it) ?: MainViewState(it)
        }

    }

    fun viewState(): LiveData<MainViewState> = viewStateLiveData
    fun add(title: String, text: String) {
        //NotesRepository.addNotes(title, text)
    }

}