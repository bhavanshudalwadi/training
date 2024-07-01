package com.bhavanshu.dalwadi.fungallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.bhavanshu.dalwadi.fungallery.apis.GalleryAPI
import com.bhavanshu.dalwadi.fungallery.databinding.ActivityMainBinding
import com.bhavanshu.dalwadi.fungallery.fragments.AlbumsFragment
import com.bhavanshu.dalwadi.fungallery.viewmodels.AlbumViewModel
import com.bhavanshu.dalwadi.fungallery.viewmodels.AlbumViewModelFactory
import com.bhavanshu.dalwadi.fungallery.viewmodels.PhotoViewModel
import com.bhavanshu.dalwadi.fungallery.viewmodels.PhotoViewModelFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var albumViewModel: AlbumViewModel
    lateinit var photoViewModel: PhotoViewModel

    private val api = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create<GalleryAPI>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        setUpViewModel()

        // Bottom Navigation Setup
        binding.bottomNavigation.background = null
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.bottom_albums -> openFragment(AlbumsFragment())
                R.id.bottom_photos -> openFragment(AlbumsFragment())
            }
            true
        }

        // Seting Default Fragment
        openFragment(AlbumsFragment())
    }

    private fun setUpViewModel() {
        val albumViewModelProviderFactory = AlbumViewModelFactory(application, api)
        albumViewModel = ViewModelProvider(this, albumViewModelProviderFactory)[AlbumViewModel::class.java]

        val photoViewModelProviderFactory = PhotoViewModelFactory(application, api)
        photoViewModel = ViewModelProvider(this, photoViewModelProviderFactory)[PhotoViewModel::class.java]
    }

    fun openFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }
}