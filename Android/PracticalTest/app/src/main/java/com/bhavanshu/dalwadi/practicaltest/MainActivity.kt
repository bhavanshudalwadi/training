package com.bhavanshu.dalwadi.practicaltest

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.bhavanshu.dalwadi.practicaltest.database.CashMangemantDatabase
import com.bhavanshu.dalwadi.practicaltest.databinding.ActivityMainBinding
import com.bhavanshu.dalwadi.practicaltest.fragments.CategoriesFragment
import com.bhavanshu.dalwadi.practicaltest.fragments.ContactsFragment
import com.bhavanshu.dalwadi.practicaltest.fragments.EditContactFragment
import com.bhavanshu.dalwadi.practicaltest.repositories.CategoryRepository
import com.bhavanshu.dalwadi.practicaltest.repositories.ContactRepository
import com.bhavanshu.dalwadi.practicaltest.viewmodels.CategoryViewModel
import com.bhavanshu.dalwadi.practicaltest.viewmodels.CategoryViewModelFactory
import com.bhavanshu.dalwadi.practicaltest.viewmodels.ContactViewModel
import com.bhavanshu.dalwadi.practicaltest.viewmodels.ContactViewModelFactory
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    lateinit var categoryViewModel: CategoryViewModel
    lateinit var contactViewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        setUpViewModel()

        lifecycleScope.launch {

        }

        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.nav_open, R.string.nav_close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navDrawer.setNavigationItemSelectedListener(this)

        openFragment(CategoriesFragment())
    }

    private fun setUpViewModel() {
        val categoryRepository = CategoryRepository(CashMangemantDatabase(this))
        val categoryViewModelProviderFactory = CategoryViewModelFactory(application, categoryRepository)
        categoryViewModel = ViewModelProvider(this, categoryViewModelProviderFactory)[CategoryViewModel::class.java]

        val contactRepository = ContactRepository(CashMangemantDatabase(this))
        val contactViewModelProviderFactory = ContactViewModelFactory(application, contactRepository)
        contactViewModel = ViewModelProvider(this, contactViewModelProviderFactory)[ContactViewModel::class.java]
    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }else {
            super.onBackPressedDispatcher.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_add_category -> openFragment(CategoriesFragment())
            R.id.nav_add_contact -> openFragment(EditContactFragment())
            R.id.nav_contact_list -> openFragment(ContactsFragment())
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    fun openFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }
}