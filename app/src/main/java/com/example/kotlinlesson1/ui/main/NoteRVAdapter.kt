package com.example.kotlinlesson1.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinlesson1.R
import com.example.kotlinlesson1.data.entity.Note
import com.example.kotlinlesson1.data.entity.Note.Color.*
import kotlinx.android.synthetic.main.item_note.view.*

class NoteRVAdapter(val onItemViewClick: ((Note) -> Unit)? = null) : RecyclerView.Adapter<NoteRVAdapter.ViewHolder>() {

    var notes: List<Note> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        )


    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(notes[position])


   inner  class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(note: Note) = with(itemView) {
            tv_title.text = note.title
            tv_text.text = note.text

            val color = when (note.color) {
                WHITE -> R.color.WHITE
                YELLOW -> R.color.YELLOW
                GREEN -> R.color.GREEN
                BLUE -> R.color.BLUE
                RED -> R.color.RED
                VIOLET -> R.color.VIOLET
                PINK -> R.color.PINK

            }
            (this as CardView).setCardBackgroundColor(ContextCompat.getColor(itemView.context, color))

            itemView.setOnClickListener { onItemViewClick?.invoke(note) }
        }
    }


}