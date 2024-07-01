package com.bhavanshu.dalwadi.practicaltest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bhavanshu.dalwadi.practicaltest.databinding.ItemContactBinding
import com.bhavanshu.dalwadi.practicaltest.interfaces.ClickInterface
import com.bhavanshu.dalwadi.practicaltest.models.ContactModel

class ContactAdapter(
    private val contactClickInterface: ClickInterface
): RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    inner class ContactViewHolder(val itemBinding: ItemContactBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(contact: ContactModel) {
            itemBinding.contact = contact
            itemBinding.clickListener = contactClickInterface
            itemBinding.executePendingBindings()
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<ContactModel>() {
        override fun areItemsTheSame(oldItem: ContactModel, newItem: ContactModel): Boolean {
            return oldItem.id == newItem.id
                    && oldItem.firstName == newItem.firstName
                    && oldItem.lastName == newItem.lastName
                    && oldItem.mobileNumber == newItem.mobileNumber
                    && oldItem.email == newItem.email
                    && oldItem.catId == newItem.catId
                    && oldItem.image == newItem.image
        }

        override fun areContentsTheSame(oldItem: ContactModel, newItem: ContactModel): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(
            ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val currentContact = differ.currentList[position]
        holder.bind(currentContact)
    }
}