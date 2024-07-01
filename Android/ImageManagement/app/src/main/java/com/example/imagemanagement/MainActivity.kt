package com.example.imagemanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import coil.api.load
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.imagemanagement.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imgUrl = "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/8911a890-1488-4033-b210-287b6a9c5319/deisoku-89533dc1-8fce-44be-85df-f8e20387fe1a.png/v1/fill/w_1280,h_720/original_avengers___png_by_dhv123_deisoku-fullview.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9NzIwIiwicGF0aCI6IlwvZlwvODkxMWE4OTAtMTQ4OC00MDMzLWIyMTAtMjg3YjZhOWM1MzE5XC9kZWlzb2t1LTg5NTMzZGMxLThmY2UtNDRiZS04NWRmLWY4ZTIwMzg3ZmUxYS5wbmciLCJ3aWR0aCI6Ijw9MTI4MCJ9XV0sImF1ZCI6WyJ1cm46c2VydmljZTppbWFnZS5vcGVyYXRpb25zIl19.mQ24xGYANn0qKz4AQBsUGD_hP-QIWuJl6fIzoCW5mcQ"

        Glide.with(this).load("https://via.placeholder.com/600/92c952").into(binding.ivGlide)

//        Glide.with(this)
//            .load(imgUrl)
//            .diskCacheStrategy(DiskCacheStrategy.NONE)
//            .skipMemoryCache(true)
//            .into(binding.ivGlide)

        binding.ivCoil.load(imgUrl)

        Picasso.get().load(imgUrl).into(binding.ivPicasso)
//
//        binding.ivGlide.setOnClickListener {
//            val animZoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
//            binding.ivGlide.startAnimation(animZoomIn)
//        }
    }
}