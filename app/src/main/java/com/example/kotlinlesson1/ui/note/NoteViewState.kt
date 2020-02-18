package com.example.kotlinlesson1.ui.note

import com.example.kotlinlesson1.data.entity.Note
import com.example.kotlinlesson1.ui.base.BaseViewState

class NoteViewState(data: Data = Data(), error: Throwable? = null) : BaseViewState<NoteViewState.Data>(data, error) {
    data class Data(val isDeleted: Boolean = false, val note: Note? = null)
}