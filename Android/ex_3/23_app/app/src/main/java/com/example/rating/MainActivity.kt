package com.example.rating

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var ratingBar: RatingBar
    private lateinit var showRatingButton: Button
    private lateinit var ratingTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ratingBar = findViewById(R.id.ratingBar)
        showRatingButton = findViewById(R.id.showRatingButton)
        ratingTextView = findViewById(R.id.ratingTextView)
        showRatingButton.setOnClickListener {
            val rating = ratingBar.rating
            if (rating > 0) {
                ratingTextView.text = "Rating: $rating"
            } else {
                Toast.makeText(this, "Please rate before showing the value", Toast.LENGTH_SHORT).show()
            }
        }

    }
}