package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.view.children
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding
import ru.easycode.zerotoheroandroidtdd.databinding.ListItemBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }

        binding.actionButton.setOnClickListener {
            addTextView(binding.inputEditText.text.toString())
            binding.inputEditText.setText(String.format(""))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val textGroup = binding.contentLayout.children.map {
            (it as TextView).text.toString()
        }.toList()
        outState.putStringArray("array", textGroup.toTypedArray())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.getStringArray("array")?.let {
            it.forEach {
                addTextView(it)
            }
        }
    }

    private fun addTextView(text: CharSequence) {
        ListItemBinding.inflate(layoutInflater).root.run {
            this.text = text
            binding.contentLayout.addView(this)
        }
    }
}