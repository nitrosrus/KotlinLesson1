package com.example.kotlinlesson1.common

import android.content.Context
import com.example.kotlinlesson1.R
import com.example.kotlinlesson1.data.entity.Note


fun Note.Color.getColorInt(context: Context): Int =
    androidx.core.content.ContextCompat.getColor(
        context, when (this) {
            Note.Color.WHITE -> R.color.WHITE
            Note.Color.YELLOW -> R.color.YELLOW
            Note.Color.GREEN -> R.color.GREEN
            Note.Color.BLUE -> R.color.BLUE
            Note.Color.RED -> R.color.RED
            Note.Color.VIOLET -> R.color.VIOLET
            Note.Color.PINK -> R.color.PINK
        }
    )


fun Note.Color.getColorRes(): Int = when (this) {
    Note.Color.WHITE -> R.color.WHITE
    Note.Color.YELLOW -> R.color.YELLOW
    Note.Color.GREEN -> R.color.GREEN
    Note.Color.BLUE -> R.color.BLUE
    Note.Color.RED -> R.color.RED
    Note.Color.VIOLET -> R.color.VIOLET
    Note.Color.PINK -> R.color.PINK
}