package com.example.kotlinlesson1.ui.main

import com.example.kotlinlesson1.data.entity.Note
import com.example.kotlinlesson1.ui.base.BaseViewState

class MainViewState(val notes: List<Note>? = null, error: Throwable? = null): BaseViewState<List<Note>?>(notes, error)
