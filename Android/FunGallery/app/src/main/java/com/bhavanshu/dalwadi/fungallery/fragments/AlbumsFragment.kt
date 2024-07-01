package com.bhavanshu.dalwadi.fungallery.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bhavanshu.dalwadi.fungallery.MainActivity
import com.bhavanshu.dalwadi.fungallery.R
import com.bhavanshu.dalwadi.fungallery.adapters.AlbumAdapter
import com.bhavanshu.dalwadi.fungallery.databinding.FragmentAlbumsBinding
import com.bhavanshu.dalwadi.fungallery.interfaces.ItemClickListner
import com.bhavanshu.dalwadi.fungallery.models.Album
import com.bhavanshu.dalwadi.fungallery.viewmodels.AlbumViewModel

class AlbumsFragment : Fragment(R.layout.fragment_albums), ItemClickListner {

    private var albumBinding: FragmentAlbumsBinding? = null
    private val binding get() = albumBinding!!
    private lateinit var albumViewModel: AlbumViewModel
    private lateinit var albumAdapter: AlbumAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        albumBinding = FragmentAlbumsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        albumViewModel = (activity as MainActivity).albumViewModel
        setUpCategoryRecyclerView()
    }

    private fun updateUI(album: List<Album>?) {
        if(album != null) {
            if(album.isEmpty()) {
                Log.d("TAG", "No Categories Found")
                // Set TextView / ImageView That No Categories Found
            }
        }
    }

    private fun setUpCategoryRecyclerView() {
        albumAdapter = AlbumAdapter(this)

        binding.rvCategories.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = albumAdapter
        }

        activity?.let {
            val list = albumViewModel.getAllAlbums()
            albumAdapter.differ.submitList(list)
            updateUI(list)
        }
    }

    override fun onItemClick(item: Any) {
        Toast.makeText(context, "Album Id: "+(item as Album).id, Toast.LENGTH_SHORT).show()
        (activity as MainActivity).openFragment(PhotosFragment((item as Album).id))
    }
}