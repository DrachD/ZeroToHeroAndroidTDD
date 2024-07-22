package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var count: Int = 0
    private val incrementCount: Int = 2
    private val decrementCount: Int = -2
    private val minCount: Int = 0
    private val maxCount: Int = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val incrementButton = findViewById<Button>(R.id.incrementButton)
        val decrementButton = findViewById<Button>(R.id.decrementButton)
        val countTextView = findViewById<TextView>(R.id.countTextView)

        count = savedInstanceState?.getInt("count") ?: count

        countTextView.text = count.toString()

        checkButtons(incrementButton, decrementButton)

        incrementButton.setOnClickListener {
            changeCount(countTextView, incrementCount)
            checkButtons(incrementButton, decrementButton)
        }

        decrementButton.setOnClickListener {
            changeCount(countTextView, decrementCount)
            checkButtons(incrementButton, decrementButton)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
    }

    private fun changeCount(textView: TextView, value: Int) {
        count += value
        textView.text = count.toString()
    }

    private fun checkButtons(incrementButton: Button, decrementButton: Button) {
        decrementButton.isEnabled = count > minCount
        incrementButton.isEnabled = count < maxCount
    }
}