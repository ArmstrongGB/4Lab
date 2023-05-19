package com.example.a4lab

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Activity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

        val textView = findViewById<TextView>(R.id.textFromAct2)
        val intent = intent
        val text = intent.getStringExtra("text")
        textView.text = text

        val editText = findViewById<EditText>(R.id.plainText3)
        val button = findViewById<Button>(R.id.btcCh3)
        button.setOnClickListener {
            val text = editText.text.toString()
            val intent = Intent(this, Activity2::class.java)
            intent.putExtra("text", text)
            startActivityForResult(intent, 1)
        }
    }

    fun changeAct(view: android.view.View) {
        val editText = findViewById<EditText>(R.id.plainText3)
        val intent = Intent(this, Activity2::class.java)
        intent.putExtra("text", editText.text.toString())
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val textFromActivity2 = data?.getStringExtra("textFromAct2")
            val editText = findViewById<EditText>(R.id.plainText3)
            editText.setText(textFromActivity2)

            val textView = findViewById<TextView>(R.id.textFromAct2)
            textView.text = textFromActivity2
        }
    }
}