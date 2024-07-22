package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var canRemoveView: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linearLayout = findViewById<LinearLayout>(R.id.rootLayout)
        val button = findViewById<Button>(R.id.removeButton)
        val textView = findViewById<TextView>(R.id.titleTextView)

        canRemoveView = savedInstanceState?.getBoolean("canRemoveView") ?:
                canRemoveView

        removeView(linearLayout, textView, canRemoveView)

        button.setOnClickListener {
            canRemoveView = true
            removeView(linearLayout, textView, canRemoveView)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("canRemoveView", canRemoveView)
    }

    private fun removeView(parent: LinearLayout, view: View, canRemove: Boolean) {
        if (canRemove) {
            parent.removeView(view)
        }
    }
}