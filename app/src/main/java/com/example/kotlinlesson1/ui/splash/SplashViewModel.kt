package com.example.kotlinlesson1.ui.splash

import com.example.kotlinlesson1.data.NotesRepository
import com.example.kotlinlesson1.data.errors.NoAuthException
import com.example.kotlinlesson1.ui.base.BaseViewModel

class SplashViewModel(private val notesRepository: NotesRepository) :
    BaseViewModel<Boolean?, SplashViewState>() {

    fun requestUser() {
        notesRepository.getCurrentUser().observeForever {
            viewStateLiveData.value = it?.let {
                SplashViewState(authenticated = true)
            } ?: let {
                SplashViewState(error = NoAuthException())
            }
        }
    }
}
