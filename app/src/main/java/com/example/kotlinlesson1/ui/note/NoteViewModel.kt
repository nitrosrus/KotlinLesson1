package com.example.kotlinlesson1.ui.note

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.kotlinlesson1.data.NotesRepository
import com.example.kotlinlesson1.data.entity.Note
import com.example.kotlinlesson1.data.model.NoteResult
import com.example.kotlinlesson1.ui.base.BaseViewModel

class NoteViewModel : BaseViewModel<Note?, NoteViewState>() {
    init {
        viewStateLiveData.value = NoteViewState()
    }

    private var pendingNote: Note? = null

    fun save(note: Note) {
        pendingNote = note
    }

    fun loadNote(noteId: String) {

        NotesRepository.getNoteById(noteId).observeForever(object : Observer<NoteResult> {
            override fun onChanged(t: NoteResult?) {
                t ?: return
                when (t) {

                    is NoteResult.Success<*> -> {
                        viewStateLiveData.value = NoteViewState(note = t.data as Note)
                    }
                    is NoteResult.Error -> {
                        viewStateLiveData.value = NoteViewState(error = t.error)
                    }
                }
            }
        })
    }

    override fun onCleared() {
        pendingNote?.let { NotesRepository.saveNote(it) }

    }
}