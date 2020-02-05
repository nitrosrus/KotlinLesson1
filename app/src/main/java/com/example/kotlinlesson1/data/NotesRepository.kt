package com.example.kotlinlesson1.data

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlinlesson1.data.entity.Note
import java.util.*

object NotesRepository {
    private val notesLiveData = MutableLiveData<List<Note>>()
    private val notes: MutableList<Note> = mutableListOf()


    init {
        notes.add(
            Note(
                UUID.randomUUID().toString(),
                "заметка 1",
                "какойто тект заметки",
                Note.Color.YELLOW
            )
        )
//        notes = mutableListOf(
//            Note("заметка 1", "какойто тект заметки",Color.LTGRAY),
//            Note("заметка 2", "какойто тект заметки", Color.MAGENTA),
//            Note("заметка 3", "какойто тект заметки",  Color.CYAN),
//            Note("заметка 4", "какойто тект заметки",  Color.GREEN),
//            Note("заметка 5", "какойто тект заметки",  Color.YELLOW),
//            Note("заметка 6", "какойто тект заметки", 0xfff06292.toInt())

    }

    init {
        notesLiveData.value = notes
    }

    fun saveNote(note: Note) {
        addOrReplace(note)
        notesLiveData.value = notes
    }

    fun addOrReplace(note: Note) {
        for (i in notes.indices) {
            if (notes[i] == note) {
                notes[i] = note
                return
            }
        }
        notes.add(note)
    }

//    fun addNotes(title: String, text: String) {
//        notes.add(Note(UUID.randomUUID().toString(), title, text, Note.Color.GREEN))
//        println("add notes")
//    }





    fun getNotes(): LiveData<List<Note>> {
        return notesLiveData
    }
}