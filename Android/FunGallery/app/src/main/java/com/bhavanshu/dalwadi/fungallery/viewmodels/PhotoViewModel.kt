package com.bhavanshu.dalwadi.fungallery.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.bhavanshu.dalwadi.fungallery.apis.GalleryAPI
import com.bhavanshu.dalwadi.fungallery.models.Photo
import kotlinx.coroutines.launch

class PhotoViewModel(app: Application, private val api: GalleryAPI): AndroidViewModel(app) {
    var photos: List<Photo> = emptyList()

    fun getPhotosByAlbumId(albumId: Int): List<Photo> {
        viewModelScope.launch {
            try {
                val response = api.getPhotos(albumId)
                if (response.isSuccessful) {
                    photos = response.body()!!

                    Log.d("TAG", photos.toString())
                } else {
                    Log.d("TAG", "Response unsuccessful: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("TAG", "Error fetching photos", e)
            }
        }
        return photos
    }
}