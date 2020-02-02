package com.example.kotlinlesson1.data

import android.graphics.Color
import com.example.kotlinlesson1.data.entity.Note

object NotesRepository {
    private val notes: MutableList<Note> = mutableListOf()


    init {
        notes.add(Note("заметка 1", "какойто тект заметки",Color.YELLOW))
//        notes = mutableListOf(
//            Note("заметка 1", "какойто тект заметки",Color.LTGRAY),
//            Note("заметка 2", "какойто тект заметки", Color.MAGENTA),
//            Note("заметка 3", "какойто тект заметки",  Color.CYAN),
//            Note("заметка 4", "какойто тект заметки",  Color.GREEN),
//            Note("заметка 5", "какойто тект заметки",  Color.YELLOW),
//            Note("заметка 6", "какойто тект заметки", 0xfff06292.toInt())

    }


    fun addNotes(title: String, text: String) {
        notes.add(Note(title, text,Color.GREEN))
        println("add notes")
    }


    fun editNotes(title: String, text: String,  id: Int) {
        notes.set(id, (Note(title, text,Color.CYAN)))
    }

    fun deleteNotes(id: Int) {
        notes.removeAt(id)
    }

    fun getNotes(): List<Note> {
        return notes
    }
}