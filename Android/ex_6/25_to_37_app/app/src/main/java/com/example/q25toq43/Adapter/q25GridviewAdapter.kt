package com.example.q25toq43.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.q25toq43.databinding.Q25GridAdapterBinding

class q25GridviewAdapter(private val context: Context, private val items: ArrayList<String>) :
    RecyclerView.Adapter<q25GridviewAdapter.ItemViewHolder>() {

    class ItemViewHolder(val binding: Q25GridAdapterBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = Q25GridAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return q25GridviewAdapter.ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.binding.textView.text = items[position]
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addMoreItems(newItems: ArrayList<String>) {
        val startPos = items.size
        items.addAll(newItems)
        notifyItemRangeInserted(startPos, newItems.size)
    }
}
