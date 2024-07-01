package com.example.cashmanagement.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cashmanagement.databinding.ItemCategoryBinding
import com.example.cashmanagement.interfaces.DeleteInterface
import com.example.cashmanagement.models.CategoryModel
import com.example.cashmanagement.viewmodels.CategoryViewModel

class CategoryAdapter(
    private val categoryDeleteInterface: DeleteInterface
): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(val itemBinding: ItemCategoryBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(category: CategoryModel) {
            itemBinding.category = category
            itemBinding.deleteListener = categoryDeleteInterface
            itemBinding.executePendingBindings()
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<CategoryModel>() {
        override fun areItemsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
            return oldItem.id == newItem.id && oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val currentCategory = differ.currentList[position]
        holder.bind(currentCategory)
//        holder.itemBinding.tvCategoryName.text = currentCategory.name
    }
}