package com.bhavanshu.dalwadi.fungallery.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bhavanshu.dalwadi.fungallery.MainActivity
import com.bhavanshu.dalwadi.fungallery.R
import com.bhavanshu.dalwadi.fungallery.adapters.AlbumAdapter
import com.bhavanshu.dalwadi.fungallery.adapters.PhotoAdapter
import com.bhavanshu.dalwadi.fungallery.databinding.FragmentAlbumsBinding
import com.bhavanshu.dalwadi.fungallery.databinding.FragmentPhotosBinding
import com.bhavanshu.dalwadi.fungallery.interfaces.ItemClickListner
import com.bhavanshu.dalwadi.fungallery.models.Album
import com.bhavanshu.dalwadi.fungallery.models.Photo
import com.bhavanshu.dalwadi.fungallery.viewmodels.AlbumViewModel
import com.bhavanshu.dalwadi.fungallery.viewmodels.PhotoViewModel

class PhotosFragment(
    private val albumId: Int
) : Fragment(R.layout.fragment_albums), ItemClickListner {

    private var photosBinding: FragmentPhotosBinding? = null
    private val binding get() = photosBinding!!
    private lateinit var photoViewModel: PhotoViewModel
    private lateinit var photoAdapter: PhotoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        photosBinding = FragmentPhotosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        photoViewModel = (activity as MainActivity).photoViewModel
        setUpCategoryRecyclerView()
    }

    private fun updateUI(album: List<Photo>?) {
        if(album != null) {
            if(album.isEmpty()) {
                Log.d("TAG", "No Categories Found")
                // Set TextView / ImageView That No Categories Found
            }
        }
    }

    private fun setUpCategoryRecyclerView() {
        photoAdapter = PhotoAdapter(this, requireContext())

        binding.rvPhotos.apply {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = photoAdapter
        }

        activity?.let {
            val list = photoViewModel.getPhotosByAlbumId(albumId)
            photoAdapter.differ.submitList(list)
            updateUI(list)
        }
    }

    override fun onItemClick(item: Any) {
//        (activity as MainActivity).openFragment(PhotosFragment((item as Photo).id))
        Toast.makeText(context, "Photo Id: "+(item as Photo).id, Toast.LENGTH_SHORT).show()
    }
}