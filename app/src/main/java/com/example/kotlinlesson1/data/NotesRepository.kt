package com.example.kotlinlesson1.data

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlinlesson1.data.entity.Note
import com.example.kotlinlesson1.data.provider.FireStoreProvider
import com.example.kotlinlesson1.data.provider.RemoteDataProvider
import java.util.*

object NotesRepository {
    private val remoteProvider: RemoteDataProvider = FireStoreProvider()


    fun getNoteById(id: String) = remoteProvider.getNoteById(id)
    fun saveNote(note: Note) = remoteProvider.saveNote(note)
    fun getNotes() = remoteProvider.subsrcibeToAllNotes()
    fun getCurrentUser() = remoteProvider.getCurrentUser()

}