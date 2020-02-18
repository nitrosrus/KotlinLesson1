package com.example.kotlinlesson1.data.provider

import androidx.lifecycle.LiveData
import com.example.kotlinlesson1.data.entity.Note
import com.example.kotlinlesson1.data.entity.User
import com.example.kotlinlesson1.data.model.NoteResult

interface RemoteDataProvider {
    fun subscribeToAllNotes(): LiveData<NoteResult>
    fun getNoteById(id: String): LiveData<NoteResult>
    fun saveNote(note: Note): LiveData<NoteResult>
    fun getCurrentUser(): LiveData<User?>
    fun deleteNote(noteId: String): LiveData<NoteResult>
}