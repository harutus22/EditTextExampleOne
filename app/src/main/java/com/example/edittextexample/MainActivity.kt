package com.example.edittextexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doBeforeTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
        addTextWatchers()
    }

    private fun setListeners() {
        editOne.setOnEditorActionListener(editorListener)
        editTwo.setOnEditorActionListener(editorListener)
    }

    private val editorListener = TextView.OnEditorActionListener { _, actionId, _ ->
        when(actionId){
            EditorInfo.IME_ACTION_NEXT -> Toast.makeText(this@MainActivity, "Next", Toast.LENGTH_SHORT).show()
            EditorInfo.IME_ACTION_SEND -> Toast.makeText(this@MainActivity, "Send", Toast.LENGTH_SHORT).show()
            //this let us do some work after the specified id is clicked
        }
        false
    }

    private fun addTextWatchers(){
        editOne.addTextChangedListener(firstTextWatcher)
        editTwo.addTextChangedListener(firstTextWatcher)
    }

    private val firstTextWatcher = object : TextWatcher{
        override fun afterTextChanged(s: Editable?) {

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val firstInput = editOne.text.toString().trim()
            val secondInput = editTwo.text.toString().trim()

            button.isEnabled = (firstInput.isNotEmpty() && secondInput.isNotEmpty())
        }

    }
}
