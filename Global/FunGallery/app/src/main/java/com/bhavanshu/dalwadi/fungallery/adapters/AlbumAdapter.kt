package com.bhavanshu.dalwadi.fungallery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bhavanshu.dalwadi.fungallery.databinding.ItemAlbumBinding
import com.bhavanshu.dalwadi.fungallery.interfaces.ItemClickListner
import com.bhavanshu.dalwadi.fungallery.models.Album

class AlbumAdapter(
    private val itemClickListner: ItemClickListner
): RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    inner class AlbumViewHolder(val itemBinding: ItemAlbumBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(album: Album) {
            itemBinding.album = album
            itemBinding.itemClickInterface = itemClickListner
            itemBinding.executePendingBindings()
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<Album>() {
        override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
            return oldItem.id == newItem.id && oldItem.title == newItem.title && oldItem.userId == newItem.userId
        }

        override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        return AlbumViewHolder(
            ItemAlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val currentAlbum = differ.currentList[position]
        holder.bind(currentAlbum)
//        holder.itemBinding.tvAlbumName.text = currentAlbum.name
    }
}