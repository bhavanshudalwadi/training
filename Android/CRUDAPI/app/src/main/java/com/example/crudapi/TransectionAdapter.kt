package com.example.crudapi

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.SimpleCursorAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crudapi.databinding.ActivityMainBinding
import com.example.crudapi.databinding.TransectionItemBinding

class TransectionAdapter(private val context: Context, private var payments: List<PaymentModel>): RecyclerView.Adapter<TransectionAdapter.TransactionViewHolder>() {
    private lateinit var binding: TransectionItemBinding

    class TransactionViewHolder(val binding: TransectionItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        binding = TransectionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TransectionAdapter.TransactionViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return payments.size
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.binding.txtDt.text = payments[position].date
        holder.binding.txtTransections.text = payments[position].total_transactions.toString()
        holder.binding.txtCollection.text = payments[position].total_collection.toString()

        holder.binding.rvTransections.layoutManager = LinearLayoutManager(context)
        holder.binding.rvTransections.adapter = PaymentAdapter(context, payments[position].transactions)
    }

    fun updateData(payment1: List<PaymentModel>) {
        payments = payment1
        notifyItemRangeInserted(payments.size, payment1.size)
    }
}