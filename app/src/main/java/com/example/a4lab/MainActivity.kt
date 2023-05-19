package com.example.a4lab

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView =
            findViewById<TextView>(R.id.textFromAct2)
        val intent = intent
        if (intent != null) {
            val text = intent.getStringExtra("text")
            textView.text = text
        }
        val exitButton = findViewById<Button>(R.id.exitButton)
        exitButton.setOnClickListener {
            val intent = Intent(this, Activity1::class.java)
            startActivity(intent)
        }
    }
    fun changeAct(view: android.view.View) {
        val editText =
            findViewById<EditText>(R.id.plainText1)
        val intent = Intent(this, Activity2::class.java)
        intent.putExtra("text",
            editText.text.toString())
        startActivityForResult(intent, 1)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val textFromAct2 = data?.getStringExtra("textFromAct2")
            val textView = findViewById<TextView>(R.id.textFromAct2)
            textView.text = textFromAct2
        }
    }
}
