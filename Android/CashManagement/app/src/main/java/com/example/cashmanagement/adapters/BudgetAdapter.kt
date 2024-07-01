package com.example.cashmanagement.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Lifecycling
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cashmanagement.databinding.ItemBudgetBinding
import com.example.cashmanagement.databinding.ItemCategoryBinding
import com.example.cashmanagement.interfaces.DeleteInterface
import com.example.cashmanagement.models.BudgetModel
import com.example.cashmanagement.models.CategoryModel
import com.example.cashmanagement.viewmodels.BudgetViewModel
import com.example.cashmanagement.viewmodels.CategoryViewModel

class BudgetAdapter(
    private val budgetDeleteInterface: DeleteInterface,
    private val categoryViewModel: CategoryViewModel,
    private val lifecycleOwner: LifecycleOwner
): RecyclerView.Adapter<BudgetAdapter.BudgetViewHolder>() {

    inner class BudgetViewHolder(val itemBinding: ItemBudgetBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(budget: BudgetModel) {
            itemBinding.budget = budget
//            itemBinding.tvCategory.text = categoryViewModel.getCategory(budget.catId).name

            categoryViewModel.getAllCategory().observe(lifecycleOwner) { categories ->
                itemBinding.tvCategory.text = categories.find { cat -> cat.id == budget.catId }?.name
            }

//            itemBinding.tvCategory.text = categoryViewModel.getCategory(budget.id).name

            itemBinding.deleteListener = budgetDeleteInterface
            itemBinding.executePendingBindings()
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<BudgetModel>() {
        override fun areItemsTheSame(oldItem: BudgetModel, newItem: BudgetModel): Boolean {
            return oldItem.id == newItem.id && oldItem.amount == newItem.amount && oldItem.catId == newItem.catId
        }

        override fun areContentsTheSame(oldItem: BudgetModel, newItem: BudgetModel): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BudgetViewHolder {
        return BudgetViewHolder(
            ItemBudgetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: BudgetViewHolder, position: Int) {
        val currentBudget = differ.currentList[position]
        holder.bind(currentBudget)
    }
}