package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var count: Int = 0
    private val addCount: Int = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val incrementButton = findViewById<Button>(R.id.incrementButton)
        val countTextView = findViewById<TextView>(R.id.countTextView)

        count = savedInstanceState?.getInt("count") ?: 0
        countTextView.text = count.toString()

        incrementButton.setOnClickListener {
            count += addCount
            countTextView.text = count.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
    }
}