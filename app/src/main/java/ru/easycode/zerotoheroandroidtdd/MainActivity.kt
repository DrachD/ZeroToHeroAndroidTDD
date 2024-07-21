package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.changeButton)
        val text = findViewById<TextView>(R.id.titleTextView)

        val str = savedInstanceState?.getString("text")
            ?: "Hello World!"

        text.text = String.format(str)

        button.setOnClickListener {
            text.text = String.format("I am an Android Developer!")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("text", "I am an Android Developer!")
    }
}