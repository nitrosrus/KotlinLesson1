package com.example.kotlinlesson1.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.kotlinlesson1.data.NotesRepository
import com.example.kotlinlesson1.data.entity.Note
import com.example.kotlinlesson1.data.model.NoteResult
import com.example.kotlinlesson1.ui.base.BaseViewModel

class MainViewModel() : BaseViewModel<List<Note>?, MainViewState>() {

    private val notesObserver = object : Observer<NoteResult> {
        override fun onChanged(t: NoteResult?) {
            t ?: return

            when (t) {
                is NoteResult.Success<*> -> {
                    viewStateLiveData.value = MainViewState(notes = t.data as? List<Note>)
                }
                is NoteResult.Error -> {
                    viewStateLiveData.value = MainViewState(error = t.error)
                }

            }
        }

    }
    private val repositoryNote = NotesRepository.getNotes()

    init {
        viewStateLiveData.value = MainViewState()
        repositoryNote.observeForever(notesObserver)
    }

    override fun onCleared() {
        repositoryNote.removeObserver(notesObserver)
        super.onCleared()
    }


}

