package com.example.kotlinlesson1.ui.main

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.kotlinlesson1.R

class LogoutDialog: DialogFragment() {

    companion object {
        val TAG = LogoutDialog::class.java.name + "TAG"
        fun createInstance() = LogoutDialog()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?) =
        AlertDialog.Builder(context)
            .setTitle(getString(R.string.logout_dialog_title))
            .setMessage(getString(R.string.logout_dialog_message))

            .setPositiveButton(getString(R.string.logout_dialog_ok))
            { dialog, which ->
                (activity as LogoutListener).onLogout() }

            .setNegativeButton(getString(R.string.logout_dialog_cancel))
            { dialog, which ->  dismiss() }

            .create()


    interface LogoutListener{
        fun onLogout()
    }


}