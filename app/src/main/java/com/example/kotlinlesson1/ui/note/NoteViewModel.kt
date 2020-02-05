package com.example.kotlinlesson1.ui.note

import androidx.lifecycle.ViewModel
import com.example.kotlinlesson1.data.NotesRepository
import com.example.kotlinlesson1.data.entity.Note

class NoteViewModel : ViewModel() {
    private var pendingNote: Note? = null
    fun save(note: Note) {
        pendingNote = note
    }

    override fun onCleared() {
        pendingNote?.let { NotesRepository.saveNote(it) }

    }
}