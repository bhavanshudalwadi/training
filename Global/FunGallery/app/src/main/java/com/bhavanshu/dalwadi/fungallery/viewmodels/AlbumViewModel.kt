package com.bhavanshu.dalwadi.fungallery.viewmodels

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.bhavanshu.dalwadi.fungallery.apis.GalleryAPI
import com.bhavanshu.dalwadi.fungallery.models.Album
import kotlinx.coroutines.launch

class AlbumViewModel(app: Application, private val api: GalleryAPI): AndroidViewModel(app) {
    var albums: List<Album> = emptyList()

    fun getAllAlbums(): List<Album> {
        viewModelScope.launch {
            try {
                val response = api.getAlbums()
                if (response.isSuccessful) {
                    albums = response.body()!!

                    Log.d("TAG", albums.toString())
                } else {
                    Log.d("TAG", "Response unsuccessful: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("TAG", "Error fetching albums "+e.message.toString())
            }
        }
        return albums
    }
}