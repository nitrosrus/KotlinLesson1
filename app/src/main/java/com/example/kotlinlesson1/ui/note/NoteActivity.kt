package com.example.kotlinlesson1.ui.note

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinlesson1.R
import com.example.kotlinlesson1.data.entity.Note
import com.example.kotlinlesson1.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.activity_note.*

import java.text.SimpleDateFormat
import java.util.*

class NoteActivity : BaseActivity<Note?, NoteViewState>() {
    companion object {
        private val EXTRA_NOTE = NoteActivity::class.java.name + "extra.NOTE"
        private const val DATE_TIME_FORMAT = "dd.MM.yy HH:mm"
        private const val SAVE_DELAY = 2000L


        fun start(contex: Context, noteId: Note? = null) {
            val intent = Intent(contex, NoteActivity::class.java)
            intent.putExtra(EXTRA_NOTE, noteId)
            contex.startActivity(intent)
        }
    }

    override val layoutRes = R.layout.activity_note
    override val viewModel: NoteViewModel by lazy { ViewModelProvider(this).get(NoteViewModel::class.java) }
    private var note: Note? = null

    val textChangeListener = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            saveNote()
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val noteId = intent.getStringExtra(EXTRA_NOTE)



        noteId?.let {
            viewModel.loadNote(it)
        } ?: let {
            supportActionBar?.title = getString(R.string.new_note_title)
        }

        btn_save.setOnClickListener { onBackPressed() }
    }


    override fun renderData(data: Note?) {
        this.note = data
        supportActionBar?.title = this.note?.let {
            SimpleDateFormat(DATE_TIME_FORMAT, Locale.getDefault()).format(note!!.lastChanged)
        } ?: getString(R.string.new_note_title)

        initView()
    }

    fun initView() {

        note?.let { note ->
            et_title.setText(note.title)
            et_body.setText(note.text)

            val color = when (note.color) {
                Note.Color.WHITE -> R.color.WHITE
                Note.Color.YELLOW -> R.color.YELLOW
                Note.Color.GREEN -> R.color.GREEN
                Note.Color.BLUE -> R.color.BLUE
                Note.Color.RED -> R.color.RED
                Note.Color.VIOLET -> R.color.VIOLET
                Note.Color.PINK -> R.color.PINK

            }
            toolbar.setBackgroundColor(ContextCompat.getColor(this, color))

        }
        et_title.addTextChangedListener(textChangeListener)
        et_body.addTextChangedListener(textChangeListener)
    }

    fun saveNote() {
        if (et_title.text == null || et_title.text!!.length < 3) return


            note = note?.copy(
                title = et_title.text.toString(),
                text = et_body.text.toString(),
                lastChanged = Date()
            ) ?: Note(
                UUID.randomUUID().toString(),
                et_title.text.toString(),
                et_body.text.toString()
            )

        note?.let { viewModel.save(it) }


    }

  //  private fun createNewNote(): Note = Note(UUID.randomUUID().toString(), et_title.text.toString(), et_body.text.toString())


    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home -> {
            onBackPressed()
            true

        }
        else -> super.onOptionsItemSelected(item)
    }
}