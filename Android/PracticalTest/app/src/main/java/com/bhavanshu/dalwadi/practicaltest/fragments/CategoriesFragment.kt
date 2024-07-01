package com.bhavanshu.dalwadi.practicaltest.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bhavanshu.dalwadi.practicaltest.MainActivity
import com.bhavanshu.dalwadi.practicaltest.R
import com.bhavanshu.dalwadi.practicaltest.adapters.CategoryAdapter
import com.bhavanshu.dalwadi.practicaltest.databinding.FragmentCategoriesBinding
import com.bhavanshu.dalwadi.practicaltest.interfaces.ClickInterface
import com.bhavanshu.dalwadi.practicaltest.models.CategoryModel
import com.bhavanshu.dalwadi.practicaltest.viewmodels.CategoryViewModel

class CategoriesFragment : Fragment(R.layout.fragment_categories), ClickInterface {

    private var categoryBinding: FragmentCategoriesBinding? = null
    private val binding get() = categoryBinding!!
    private lateinit var categoryViewModel: CategoryViewModel
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var category: CategoryModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        categoryBinding = FragmentCategoriesBinding.inflate(inflater, container, false)

        categoryBinding!!.btnAddCategory.setOnClickListener {
            if(categoryBinding!!.btnAddCategory.text == "Save") {
                saveCategory(it)
            }else {
                updateCategory(it)
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoryViewModel = (activity as MainActivity).categoryViewModel
        setUpCategoryRecyclerView()
    }

    private fun setUpCategoryRecyclerView() {
        categoryAdapter = CategoryAdapter(this)

        binding.rvCategories.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = categoryAdapter
        }

        activity?.let {
            categoryViewModel.getAllCategory().observe(viewLifecycleOwner) { categories ->
                categoryAdapter.differ.submitList(categories)
            }
        }
    }

    private fun saveCategory(view: View) {
        val categoryName = binding.etCategoryName.text.toString().trim()

        if(categoryName.isNotEmpty()) {
            val category = CategoryModel(name = categoryName)
            categoryViewModel.addCategory(category)
            binding.btnAddCategory.text = "Save"
            binding.etCategoryName.setText("")
            setUpCategoryRecyclerView()

            Toast.makeText(context, "Category Added Successful", Toast.LENGTH_LONG).show()
        }else {
            Toast.makeText(context, "Please Enter Category Details", Toast.LENGTH_LONG).show()
        }
    }

    private fun updateCategory(view: View) {
        val categoryName = binding.etCategoryName.text.toString().trim()

        Log.d("CategoryFragment", categoryName)

        if(categoryName.isNotEmpty()) {
            category.name = categoryName
            categoryViewModel.updateCategory(category)

            binding.btnAddCategory.text = "Save"
            category = CategoryModel(0, "")
            binding.etCategoryName.setText("")

            setUpCategoryRecyclerView()

            Toast.makeText(context, "Category Updated Successful", Toast.LENGTH_LONG).show()
        }else {
            Toast.makeText(context, "Please Enter Category Details", Toast.LENGTH_LONG).show()
        }
    }

    override fun onIconClick(modelObj: Any, action: Int) {
        if(action == 1) {
            categoryViewModel.deleteCategory(modelObj as CategoryModel)
        }else if(action == 2) {
            binding.btnAddCategory.text = "Update"
            category = (modelObj as CategoryModel)
            binding.etCategoryName.setText(category.name)
        }
    }
}