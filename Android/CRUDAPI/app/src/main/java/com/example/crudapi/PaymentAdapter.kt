package com.example.crudapi

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crudapi.databinding.PaymentItemBinding

class PaymentAdapter(private val context: Context, private var transections: List<TransectionModel>) : RecyclerView.Adapter<PaymentAdapter.PaymentViewHolder>() {

    private lateinit var binding: PaymentItemBinding

    class PaymentViewHolder(val binding: PaymentItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        binding = PaymentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PaymentAdapter.PaymentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return transections.size
    }

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        holder.binding.txtTime.text = transections[position].time
        holder.binding.txtAmount.text = "₹ ${transections[position].amount}"
        holder.binding.txtFrom.text = transections[position].from
        holder.binding.txtRefNo.text = transections[position].ref_no
    }
}