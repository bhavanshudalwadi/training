package com.bhavanshu.dalwadi.fungallery.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bhavanshu.dalwadi.fungallery.MainActivity
import com.bhavanshu.dalwadi.fungallery.databinding.ItemPhotoBinding
import com.bhavanshu.dalwadi.fungallery.interfaces.ItemClickListner
import com.bhavanshu.dalwadi.fungallery.models.Photo
import com.bumptech.glide.Glide
import kotlin.coroutines.coroutineContext

class PhotoAdapter(
    private val itemClickListner: ItemClickListner,
    private val context: Context
): RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    inner class PhotoViewHolder(val itemBinding: ItemPhotoBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(photo: Photo) {
            itemBinding.photo = photo
            Glide.with(context).load(photo.thumbnailUrl).into(itemBinding.imageView)
            itemBinding.itemClickInterface = itemClickListner
            itemBinding.executePendingBindings()
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.id == newItem.id && oldItem.title == newItem.title && oldItem.url == newItem.url && oldItem.thumbnailUrl == newItem.thumbnailUrl && oldItem.albumId == newItem.albumId
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoAdapter.PhotoViewHolder {
        return PhotoViewHolder(
            ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: PhotoAdapter.PhotoViewHolder, position: Int) {
        val currentAlbum = differ.currentList[position]
        holder.bind(currentAlbum)
    }
}