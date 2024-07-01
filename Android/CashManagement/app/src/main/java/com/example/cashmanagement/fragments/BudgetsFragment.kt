package com.example.cashmanagement.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cashmanagement.MainActivity
import com.example.cashmanagement.R
import com.example.cashmanagement.adapters.BudgetAdapter
import com.example.cashmanagement.databinding.FragmentBudgetsBinding
import com.example.cashmanagement.databinding.FragmentCategoriesBinding
import com.example.cashmanagement.interfaces.DeleteInterface
import com.example.cashmanagement.models.BudgetModel
import com.example.cashmanagement.viewmodels.BudgetViewModel
import com.example.cashmanagement.viewmodels.CategoryViewModel

class BudgetsFragment : Fragment(R.layout.fragment_budgets), DeleteInterface {

    private var budgetBinding: FragmentBudgetsBinding? = null
    private val binding get() = budgetBinding!!
    private lateinit var budgetViewModel: BudgetViewModel
    private lateinit var categoryViewModel: CategoryViewModel
    private lateinit var budgetAdapter: BudgetAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        budgetBinding = FragmentBudgetsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        budgetViewModel = (activity as MainActivity).budgetViewModel
        categoryViewModel = (activity as MainActivity).categoryViewModel
        setUpBudgetRecyclerView()

        binding.btnAddBudget.setOnClickListener {
            (activity as MainActivity).openFragment(EditBudgetFragment())
        }
    }

    private fun updateUI(budgets: List<BudgetModel>?) {
        if(!budgets.isNullOrEmpty()) {
            Log.d("TAG", "No Budgets Found")
            // Set TextView / ImageView That No Categories Found
        }
    }

    private fun setUpBudgetRecyclerView() {
        budgetAdapter = BudgetAdapter(this, categoryViewModel, viewLifecycleOwner)

        binding.rvBudgets.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = budgetAdapter
        }

        activity?.let {
            budgetViewModel.getAllBudget().observe(viewLifecycleOwner) { budgets ->
                budgetAdapter.differ.submitList(budgets)
                updateUI(budgets)
            }
        }
    }

    override fun onDeleteIconClick(modelObj: Any) {
        budgetViewModel.deleteBudget(modelObj as BudgetModel)
    }
}