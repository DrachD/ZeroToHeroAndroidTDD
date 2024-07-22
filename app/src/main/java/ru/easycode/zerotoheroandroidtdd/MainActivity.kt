package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var count: Int = 0
    private val countAdd: Int = 2
    private val countTrigger: Int = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val incrementButton = findViewById<Button>(R.id.incrementButton)
        val countTextView = findViewById<TextView>(R.id.countTextView)

        count = savedInstanceState?.getInt("count") ?: count

        disableTextViewByCondition(incrementButton)
        countTextView.text = count.toString()

        incrementButton.setOnClickListener {
            count += countAdd
            countTextView.text = count.toString()
            disableTextViewByCondition(incrementButton)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
    }

    private fun disableTextViewByCondition(button: Button) {
        if (count >= countTrigger) {
            button.isEnabled = false
        }
    }
}