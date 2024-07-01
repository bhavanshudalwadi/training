package com.example.cashmanagement

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
import com.example.cashmanagement.database.CashMangemantDatabase
import com.example.cashmanagement.databinding.ActivityMainBinding
import com.example.cashmanagement.fragments.BudgetsFragment
import com.example.cashmanagement.fragments.CategoriesFragment
import com.example.cashmanagement.fragments.TransectionsFragment
import com.example.cashmanagement.repositories.BudgetRepository
import com.example.cashmanagement.repositories.CategoryRepository
import com.example.cashmanagement.viewmodels.BudgetViewModel
import com.example.cashmanagement.viewmodels.BudgetViewModelFactory
import com.example.cashmanagement.viewmodels.CategoryViewModel
import com.example.cashmanagement.viewmodels.CategoryViewModelFactory
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    lateinit var categoryViewModel: CategoryViewModel
    lateinit var budgetViewModel: BudgetViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(binding.root)

        // Navigation Drawer Setup
        setSupportActionBar(binding.toolbar)
        setUpViewModel()

        lifecycleScope.launch {
//            CashMangemantDatabase(this@MainActivity).getBudgetDao().insertBudget(BudgetModel(2, 2, 100.00))
//            val str = CashMangemantDatabase(this@MainActivity).getCategoryDao().getCategoryById(6)
//
//            Log.d("TAG", str.toString())
        }

        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.nav_open, R.string.nav_close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navDrawer.setNavigationItemSelectedListener(this)

        // Bottom Navigation Setup
        binding.bottomNavigation.background = null
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.bottom_transections -> openFragment(TransectionsFragment())
                R.id.bottom_categories -> openFragment(CategoriesFragment())
                R.id.bottom_budgets -> openFragment(BudgetsFragment())
            }
            true
        }

        // Seting Default Fragment
        openFragment(CategoriesFragment())
    }

    private fun setUpViewModel() {
        val categoryRepository = CategoryRepository(CashMangemantDatabase(this))
        val categoryViewModelProviderFactory = CategoryViewModelFactory(application, categoryRepository)
        categoryViewModel = ViewModelProvider(this, categoryViewModelProviderFactory)[CategoryViewModel::class.java]

        val budgetRepository = BudgetRepository(CashMangemantDatabase(this))
        val budgetViewModelProviderFactory = BudgetViewModelFactory(application, budgetRepository)
        budgetViewModel = ViewModelProvider(this, budgetViewModelProviderFactory)[BudgetViewModel::class.java]
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_transections -> openFragment(TransectionsFragment())
            R.id.nav_categories -> openFragment(CategoriesFragment())
            R.id.nav_budgets -> openFragment(BudgetsFragment())
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }else {
            super.onBackPressedDispatcher.onBackPressed()
        }
    }

    fun openFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }
}