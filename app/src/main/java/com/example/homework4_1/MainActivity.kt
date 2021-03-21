package com.example.homework4_1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var textViewChanged:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val button = findViewById<Button>(R.id.button_plus)
        val buttonNext = findViewById<Button>(R.id.button_next_activity)

        var textViewFA = findViewById<TextView>(R.id.textView)
        var number = 0
        textViewFA.text = number.toString()

        button.setOnClickListener {
            number++
            textViewFA.text = number.toString()
        }

        buttonNext.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("text", textViewFA.text.toString())
            startActivityForResult(intent,1)
        }

        var textViewChanged = findViewById<TextView>(R.id.textView)

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK && requestCode == 1) {

            textViewChanged.text = data?.getStringExtra("text_2")
        }
    }

}