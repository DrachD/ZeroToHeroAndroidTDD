package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var textIsVisible: Int = View.VISIBLE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.hideButton)
        val text = findViewById<TextView>(R.id.titleTextView)

        textIsVisible = savedInstanceState?.getInt("textIsVisible")
            ?: View.VISIBLE

        text.visibility = textIsVisible

        button.setOnClickListener {
            textIsVisible = View.GONE
            text.visibility = textIsVisible
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("textIsVisible", textIsVisible)
    }
}