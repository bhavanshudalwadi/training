package com.bhavanshu.dalwadi.fungallery.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bhavanshu.dalwadi.fungallery.apis.GalleryAPI

class PhotoViewModelFactory(val app: Application, private val api: GalleryAPI): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PhotoViewModel(app, api) as T
    }
}