package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linearLayout = findViewById<LinearLayout>(R.id.rootLayout)
        val button = findViewById<Button>(R.id.removeButton)
        val text = findViewById<TextView>(R.id.titleTextView)

        if (savedInstanceState != null) {
            changeViewState(linearLayout, button, text)
        }

        button.setOnClickListener {
            changeViewState(linearLayout, button, text)
        }
    }

    private fun changeViewState(
        linearLayout: LinearLayout,
        button: Button,
        textView: TextView
    ) {
        linearLayout.removeView(textView)
        button.isEnabled = false
    }
}