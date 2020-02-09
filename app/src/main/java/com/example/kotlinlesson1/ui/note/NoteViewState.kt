package com.example.kotlinlesson1.ui.note

import com.example.kotlinlesson1.data.entity.Note
import com.example.kotlinlesson1.ui.base.BaseViewState

class NoteViewState(note: Note? = null, error: Throwable? = null) :
    BaseViewState<Note?>(note, error)