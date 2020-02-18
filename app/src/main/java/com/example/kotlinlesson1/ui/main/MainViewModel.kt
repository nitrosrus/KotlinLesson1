package com.example.kotlinlesson1.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.kotlinlesson1.data.NotesRepository
import com.example.kotlinlesson1.data.entity.Note
import com.example.kotlinlesson1.data.model.NoteResult
import com.example.kotlinlesson1.ui.base.BaseViewModel

class MainViewModel(private val notesRepository: NotesRepository) : BaseViewModel<List<Note>?, MainViewState>() {

    private val notesObserver = object : Observer<NoteResult>{
        override fun onChanged(t: NoteResult?) {
            t ?: return

            when(t){
                is NoteResult.Success<*> -> {
                    viewStateLiveData.value = MainViewState(notes = t.data as? List<Note>)
                }
                is NoteResult.Error -> {
                    viewStateLiveData.value = MainViewState(error = t.error)
                }
            }
        }
    }

    private val repositoryNotes = notesRepository.getNotes()

    init {
        viewStateLiveData.value = MainViewState()
        repositoryNotes.observeForever(notesObserver)
    }

    fun viewState(): LiveData<MainViewState> = viewStateLiveData

    override fun onCleared() {
        repositoryNotes.removeObserver(notesObserver)
        super.onCleared()
    }

}

