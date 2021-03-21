package com.example.homework4_1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val text = intent.getStringExtra("text")
        val textViewSA =  findViewById<TextView>(R.id.second_textview)

        textViewSA.text = text
        var numberM = text!!.toInt()

        val buttonMinus = findViewById<Button>(R.id.button_minus)
        val buttonBack = findViewById<Button>(R.id.button_main_actvity)

        buttonMinus.setOnClickListener {
            numberM--
            textViewSA.text = numberM.toString()

        }

        buttonBack.setOnClickListener {
            val result = textViewSA.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("text_2", result)
            setResult(Activity.RESULT_OK,intent)
        }

    }
}