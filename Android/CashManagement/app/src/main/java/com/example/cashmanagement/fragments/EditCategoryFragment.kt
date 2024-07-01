package com.example.cashmanagement.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.cashmanagement.MainActivity
import com.example.cashmanagement.R
import com.example.cashmanagement.databinding.FragmentEditCategoryBinding
import com.example.cashmanagement.models.CategoryModel
import com.example.cashmanagement.viewmodels.CategoryViewModel

class EditCategoryFragment : Fragment(R.layout.fragment_edit_category) {

    private var editCategoryBinding: FragmentEditCategoryBinding? = null
    private val binding get() = editCategoryBinding!!
    private lateinit var categoriesViewModel: CategoryViewModel
    private lateinit var editCategoryView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        editCategoryBinding = FragmentEditCategoryBinding.inflate(inflater, container, false)

        editCategoryBinding!!.btnAddCategory.setOnClickListener {
            saveCategory(it)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        categoriesViewModel = (activity as MainActivity).categoryViewModel
        editCategoryView = view
    }

    private fun saveCategory(view: View) {
        val categoryName = binding.etCategoryName.text.toString().trim()

        if(categoryName.isNotEmpty()) {
            val category = CategoryModel(name = categoryName)
            categoriesViewModel.addCategory(category)

            Toast.makeText(context, "Category Added Successful", Toast.LENGTH_LONG).show()
            (activity as MainActivity).openFragment(CategoriesFragment())
        }else {
            Toast.makeText(context, "Please Enter Category Details", Toast.LENGTH_LONG).show()
        }
    }
}