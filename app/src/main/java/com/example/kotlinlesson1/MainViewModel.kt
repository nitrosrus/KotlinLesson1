package com.example.kotlinlesson1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinlesson1.data.NotesRepository

class MainViewModel : ViewModel() {
    private val viewStateLiveData: MutableLiveData<MainViewState> = MutableLiveData()

    init {
        viewStateLiveData.value = MainViewState(NotesRepository.getNotes())
    }

    fun viewState(): LiveData<MainViewState> = viewStateLiveData

}