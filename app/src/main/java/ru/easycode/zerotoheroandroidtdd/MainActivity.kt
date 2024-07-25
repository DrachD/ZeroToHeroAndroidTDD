package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding
import ru.easycode.zerotoheroandroidtdd.databinding.ItemListViewBinding
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var adapter: ItemListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }

        adapter = ItemListAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = adapter

        binding.actionButton.setOnClickListener {
            val text = binding.inputEditText.text.toString()
            adapter?.add(text)

            binding.inputEditText.setText(String.format(""))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        adapter?.save(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        adapter?.restore(savedInstanceState)
    }
}

class ItemListAdapter(
    private val list: ArrayList<String> = ArrayList()
) : RecyclerView.Adapter<ItemListViewHolder>() {

    fun add(text: String) {
        list.add(text)
        notifyItemInserted(list.size - 1)
    }

    fun save(bundle: Bundle) {
        bundle.putStringArrayList(KEY, list)
    }

    fun restore(bundle: Bundle) {
        bundle.getStringArrayList(KEY)?.let {
            list.addAll(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListViewHolder {
        return ItemListViewHolder(
            ItemListViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemListViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    companion object {
        private const val KEY: String = "item_list_key"
    }
}

class ItemListViewHolder(
    private val binding: ItemListViewBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(text: String) {
        binding.elementTextView.text = text
    }
}