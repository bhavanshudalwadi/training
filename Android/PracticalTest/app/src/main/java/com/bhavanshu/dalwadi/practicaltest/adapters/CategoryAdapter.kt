package com.bhavanshu.dalwadi.practicaltest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bhavanshu.dalwadi.practicaltest.databinding.ItemCategoryBinding
import com.bhavanshu.dalwadi.practicaltest.interfaces.ClickInterface
import com.bhavanshu.dalwadi.practicaltest.models.CategoryModel

class CategoryAdapter(
    private val categoryClickInterface: ClickInterface
): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(val itemBinding: ItemCategoryBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(category: CategoryModel) {
            itemBinding.category = category
            itemBinding.clickListener = categoryClickInterface
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