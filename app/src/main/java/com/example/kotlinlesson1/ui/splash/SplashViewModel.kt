package com.example.kotlinlesson1.ui.splash

import com.example.kotlinlesson1.data.NotesRepository
import com.example.kotlinlesson1.data.errors.NoAuthException
import com.example.kotlinlesson1.ui.base.BaseViewModel

class SplashViewModel() : BaseViewModel<Boolean?, SplashViewState>() {

    fun requestUser() {
        NotesRepository.getCurrentUser().observeForever {
            //TODO Я копипастил  и заметил эту надпись :)
            viewStateLiveData.value = it?.let {
                SplashViewState(authenticated = true)
            } ?: let {
                SplashViewState(error = NoAuthException())
            }
        }
    }
}