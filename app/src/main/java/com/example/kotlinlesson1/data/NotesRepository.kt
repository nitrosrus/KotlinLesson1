package com.example.kotlinlesson1.data

import android.graphics.Color
import com.example.kotlinlesson1.data.entity.Note

object NotesRepository {
    private val notes: List<Note>

    init {
        notes = listOf(
            Note("заметка 1", "какойто тект заметки",Color.LTGRAY),
            Note("заметка 2", "какойто тект заметки", Color.MAGENTA),
            Note("заметка 3", "какойто тект заметки",  Color.CYAN),
            Note("заметка 4", "какойто тект заметки",  Color.GREEN),
            Note("заметка 5", "какойто тект заметки",  Color.YELLOW),
            Note("заметка 6", "какойто тект заметки", 0xfff06292.toInt()),
            Note("заметка 1", "какойто тект заметки",Color.LTGRAY),
            Note("заметка 2", "какойто тект заметки", Color.MAGENTA),
            Note("заметка 3", "какойто тект заметки",  Color.CYAN),
            Note("заметка 4", "какойто тект заметки",  Color.GREEN),
            Note("заметка 5", "какойто тект заметки",  Color.YELLOW),
            Note("заметка 6", "какойто тект заметки", 0xfff06292.toInt()),
            Note("заметка 1", "какойто тект заметки",Color.LTGRAY),
            Note("заметка 2", "какойто тект заметки", Color.MAGENTA),
            Note("заметка 3", "какойто тект заметки",  Color.CYAN),
            Note("заметка 4", "какойто тект заметки",  Color.GREEN),
            Note("заметка 5", "какойто тект заметки",  Color.YELLOW),
            Note("заметка 6", "какойто тект заметки", 0xfff06292.toInt()),
            Note("заметка 1", "какойто тект заметки",Color.LTGRAY),
            Note("заметка 2", "какойто тект заметки", Color.MAGENTA),
            Note("заметка 3", "какойто тект заметки",  Color.CYAN),
            Note("заметка 4", "какойто тект заметки",  Color.GREEN),
            Note("заметка 5", "какойто тект заметки",  Color.YELLOW),
            Note("заметка 6", "какойто тект заметки", 0xfff06292.toInt()),
            Note("заметка 1", "какойто тект заметки",Color.LTGRAY),
            Note("заметка 2", "какойто тект заметки", Color.MAGENTA),
            Note("заметка 3", "какойто тект заметки",  Color.CYAN),
            Note("заметка 4", "какойто тект заметки",  Color.GREEN),
            Note("заметка 5", "какойто тект заметки",  Color.YELLOW),
            Note("заметка 6", "какойто тект заметки", 0xfff06292.toInt())
        )
    }



    fun getNotes(): List<Note> {
        return notes
    }
}