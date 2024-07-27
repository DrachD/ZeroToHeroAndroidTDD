package ru.easycode.zerotoheroandroidtdd

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.ItemListViewBinding

class TextViewAdapter : RecyclerView.Adapter<TextViewViewHolder>() {

    private var textList = ArrayList<CharSequence>()

    fun add(newList: List<CharSequence>) {
        val diffUtil = DiffUtilCallback(textList, newList)
        val diff = DiffUtil.calculateDiff(diffUtil)
        textList = ArrayList(newList)
        notifyItemInserted(textList.size - 1)
        diff.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TextViewViewHolder(
        ItemListViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: TextViewViewHolder, position: Int) {
        holder.bind(textList[position])
    }

    override fun getItemCount(): Int = textList.size
}

class TextViewViewHolder(private val binding: ItemListViewBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(text: CharSequence) {
        binding.elementTextView.text = text
    }
}

private class DiffUtilCallback(
    private val old: List<CharSequence>,
    private val new: List<CharSequence>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = old.size

    override fun getNewListSize(): Int = new.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition] == new[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition] == new[newItemPosition]
    }
}