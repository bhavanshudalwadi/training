package com.example.cashmanagement.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.cashmanagement.MainActivity
import com.example.cashmanagement.databinding.FragmentEditBudgetBinding
import com.example.cashmanagement.models.BudgetModel
import com.example.cashmanagement.models.CategoryModel
import com.example.cashmanagement.viewmodels.BudgetViewModel
import com.example.cashmanagement.viewmodels.CategoryViewModel

class EditBudgetFragment : Fragment() {

    private var editBudgetBinding: FragmentEditBudgetBinding? = null
    private val binding get() = editBudgetBinding!!
    private lateinit var budgetsViewModel: BudgetViewModel
    private lateinit var categoriesViewModel: CategoryViewModel
    private lateinit var editBudgetView: View

    private var categoryList: List<CategoryModel> ?= null
//    private var se

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        editBudgetBinding = FragmentEditBudgetBinding.inflate(inflater, container, false)

        editBudgetBinding!!.btnAddBudget.setOnClickListener {
            saveBudget(it)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        budgetsViewModel = (activity as MainActivity).budgetViewModel
        categoriesViewModel = (activity as MainActivity).categoryViewModel

        val adapter = ArrayAdapter<String>(
            requireContext(),
            android.R.layout.simple_dropdown_item_1line,
            mutableListOf()
        )

        val categoryNames: MutableList<String> = mutableListOf()

        categoriesViewModel.getAllCategory().observe(viewLifecycleOwner, Observer { categories ->
            categoryNames.clear()
            categoryList = null

            categories?.let { category ->
                categoryNames.addAll(category.map { cat -> cat.name })
                categoryList = category
            }

            adapter.clear()
            adapter.addAll(categoryNames)
            adapter.notifyDataSetChanged()
        })
        binding.actvCategory.setAdapter(adapter)

//        binding.actvCategory.setOnItemClickListener { _, _, position, _ ->
//            println(categoryList!![position])
//        }

        editBudgetView = view
    }

    private fun saveBudget(view: View) {
        val budgetAmount = binding.etBedgetAmount.text.toString().toDouble()
        val selectedCategoryText = binding.actvCategory.text.toString()
        val category = categoryList?.filter { it.name == selectedCategoryText }

        if(budgetAmount > 0 && category!!.isNotEmpty()) {
            val budget = BudgetModel(0, category[0].id, budgetAmount)
            budgetsViewModel.addBudget(budget)

            Toast.makeText(context, "Budget Added Successful", Toast.LENGTH_LONG).show()
            (activity as MainActivity).openFragment(BudgetsFragment())
        }else {
            Toast.makeText(context, "Please Enter Budget Details", Toast.LENGTH_LONG).show()
        }
    }
}