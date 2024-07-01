package com.bhavanshu.dalwadi.practicaltest.fragments

import android.R
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.bhavanshu.dalwadi.practicaltest.MainActivity
import com.bhavanshu.dalwadi.practicaltest.databinding.FragmentEditContactBinding
import com.bhavanshu.dalwadi.practicaltest.models.CategoryModel
import com.bhavanshu.dalwadi.practicaltest.models.ContactModel
import com.bhavanshu.dalwadi.practicaltest.viewmodels.CategoryViewModel
import com.bhavanshu.dalwadi.practicaltest.viewmodels.ContactViewModel
import kotlinx.coroutines.launch

class EditContactFragment : Fragment() {

    private var editContactBinding: FragmentEditContactBinding? = null
    private val binding get() = editContactBinding!!
    private lateinit var contactsViewModel: ContactViewModel
    private lateinit var categoriesViewModel: CategoryViewModel
    private lateinit var editContactView: View
    private var categoryList: List<CategoryModel> ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        editContactBinding = FragmentEditContactBinding.inflate(inflater, container, false)

        editContactBinding!!.btnAddCategory.setOnClickListener {
            saveContact(it)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        contactsViewModel = (activity as MainActivity).contactViewModel
        categoriesViewModel = (activity as MainActivity).categoryViewModel

        val adapter = ArrayAdapter<String>(
            requireContext(),
            R.layout.simple_dropdown_item_1line,
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

        editContactView = view
    }

    private fun saveContact(view: View) {
        val firstName = binding.etFirstName.text.toString().trim()
        val lastName = binding.etLastName.text.toString().trim()
        val mobileNumber = binding.etMobileNumber.text.toString().trim()
        val email = binding.etEmail.text.toString().trim()

        val selectedCategoryText = binding.actvCategory.text.toString()
        val category = categoryList?.filter { it.name == selectedCategoryText }

        if(firstName.isNotEmpty() && lastName.isNotEmpty() && mobileNumber.isNotEmpty() && email.isNotEmpty() && category!!.isNotEmpty()) {
            val contact = ContactModel(0, "", firstName, lastName, mobileNumber, email, category[0].id)
            contactsViewModel.addContact(contact)

            Toast.makeText(context, "Contact Added Successful", Toast.LENGTH_LONG).show()
            (activity as MainActivity).openFragment(ContactsFragment())
        }else {
            Toast.makeText(context, "Please Enter Contact Details", Toast.LENGTH_LONG).show()
        }
    }
}