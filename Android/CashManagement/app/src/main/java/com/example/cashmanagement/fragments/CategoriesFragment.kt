package com.example.cashmanagement.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cashmanagement.MainActivity
import com.example.cashmanagement.R
import com.example.cashmanagement.adapters.CategoryAdapter
import com.example.cashmanagement.databinding.FragmentCategoriesBinding
import com.example.cashmanagement.interfaces.DeleteInterface
import com.example.cashmanagement.models.CategoryModel
import com.example.cashmanagement.viewmodels.CategoryViewModel

class CategoriesFragment : Fragment(R.layout.fragment_categories), DeleteInterface {

    private var categoryBinding: FragmentCategoriesBinding? = null
    private val binding get() = categoryBinding!!
    private lateinit var categoryViewModel: CategoryViewModel
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        categoryBinding = FragmentCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoryViewModel = (activity as MainActivity).categoryViewModel
        setUpCategoryRecyclerView()

        binding.btnAddCategory.setOnClickListener {
            (activity as MainActivity).openFragment(EditCategoryFragment())
        }
    }

    private fun updateUI(category: List<CategoryModel>?) {
        if(category != null) {
            if(category.isEmpty()) {
                Log.d("TAG", "No Categories Found")
                // Set TextView / ImageView That No Categories Found
            }
        }
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
                updateUI(categories)
            }
        }
    }

    override fun onDeleteIconClick(modelObj: Any) {
        categoryViewModel.deleteCategory(modelObj as CategoryModel)
    }
}