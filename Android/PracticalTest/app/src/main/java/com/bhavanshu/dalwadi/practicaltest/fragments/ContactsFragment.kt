package com.bhavanshu.dalwadi.practicaltest.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bhavanshu.dalwadi.practicaltest.MainActivity
import com.bhavanshu.dalwadi.practicaltest.R
import com.bhavanshu.dalwadi.practicaltest.adapters.ContactAdapter
import com.bhavanshu.dalwadi.practicaltest.databinding.FragmentContactsBinding
import com.bhavanshu.dalwadi.practicaltest.interfaces.ClickInterface
import com.bhavanshu.dalwadi.practicaltest.models.ContactModel
import com.bhavanshu.dalwadi.practicaltest.viewmodels.ContactViewModel

class ContactsFragment : Fragment(R.layout.fragment_contacts), ClickInterface {

    private var contactBinding: FragmentContactsBinding? = null
    private val binding get() = contactBinding!!
    private lateinit var contactViewModel: ContactViewModel
    private lateinit var contactAdapter: ContactAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contactBinding = FragmentContactsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        contactViewModel = (activity as MainActivity).contactViewModel
        setUpContactRecyclerView()
    }

    private fun setUpContactRecyclerView() {
        contactAdapter = ContactAdapter(this)

        binding.rvContacts.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = contactAdapter
        }

        activity?.let {
            contactViewModel.getAllContact().observe(viewLifecycleOwner) { contacts ->
                contactAdapter.differ.submitList(contacts)
            }
        }
    }

    override fun onIconClick(modelObj: Any, action: Int) {
        if(action == 1) {
            contactViewModel.deleteContact(modelObj as ContactModel)
        }else if(action == 2) {
            // Edit Contact
        }
    }
}