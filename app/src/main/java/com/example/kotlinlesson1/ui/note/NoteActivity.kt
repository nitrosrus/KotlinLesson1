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
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.activity_note.*

import java.text.SimpleDateFormat
import java.util.*

class NoteActivity : AppCompatActivity() {
    companion object {
        private val EXTRA_NOTE = NoteActivity::class.java.name + "extra.NOTE"
        private const val DATE_TIME_FORMAT = "dd.MM.yy HH:mm"
        private const val SAVE_DELAY = 2000L


        fun start(contex: Context, note: Note? = null) {
            val intent = Intent(contex, NoteActivity::class.java)
            intent.putExtra(EXTRA_NOTE, note)
            contex.startActivity(intent)
        }
    }

    val textChangeListener = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            saveNote()
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

    }

    private var note: Note? = null
    lateinit var viewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)
        note = intent.getParcelableExtra(EXTRA_NOTE)
        setSupportActionBar(toolbar)

        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)

        viewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        supportActionBar?.title = note?.let {
            SimpleDateFormat(DATE_TIME_FORMAT, Locale.getDefault()).format(it.lastChanged)

        } ?: let { "новая звметка" }
        initView()

        btn_save.setOnClickListener {  }
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

        Handler().postDelayed({
            note = note?.copy(
                title = et_title.text.toString(),
                text = et_body.text.toString(),
                lastChanged = Date()
            ) ?: createNewNote()

            note?.let { viewModel.save(it) }

        }, SAVE_DELAY)
    }
private fun saveBtn(){


}
    private fun createNewNote(): Note =
        Note(UUID.randomUUID().toString(), et_title.text.toString(), et_body.text.toString())


    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home -> {
            onBackPressed()
            true

        }
        else -> super.onOptionsItemSelected(item)
    }
}