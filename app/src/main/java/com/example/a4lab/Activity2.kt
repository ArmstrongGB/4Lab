package com.example.a4lab

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val textViewFromMain = findViewById<TextView>(R.id.textFromMain)
        val intent = intent
        if (intent != null) {
            val textFromMain = intent.getStringExtra("text")
            textViewFromMain.text = textFromMain
        }

        val editText = findViewById<EditText>(R.id.plainText2)
        val btnBack = findViewById<Button>(R.id.btcCh2)
        btnBack.setOnClickListener {
            val textToPass = editText.text.toString()
            val intent = Intent()
            intent.putExtra("textFromAct2", textToPass)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}