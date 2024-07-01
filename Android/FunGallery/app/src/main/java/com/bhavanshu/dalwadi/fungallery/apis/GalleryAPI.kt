package com.bhavanshu.dalwadi.fungallery.apis

import com.bhavanshu.dalwadi.fungallery.models.Album
import com.bhavanshu.dalwadi.fungallery.models.Photo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GalleryAPI {
    @GET("/albums")
    suspend fun getAlbums(): Response<List<Album>>

    @GET("/photos")
    suspend fun getPhotos(
        @Query("albumId")  albumId :Int,
    ): Response<List<Photo>>
}