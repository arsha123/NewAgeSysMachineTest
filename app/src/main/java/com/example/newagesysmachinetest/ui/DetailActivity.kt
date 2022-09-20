package com.example.newagesysmachinetest.ui

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.newagesysmachinetest.R


class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        Log.d("cdfdf", "reached: ")

        var explanation = findViewById(R.id.explanation) as TextView
        var date = findViewById(R.id.date) as TextView
        var title = findViewById(R.id.title) as TextView
        var image = findViewById(R.id.image) as ImageView


//Extract the data…

//Extract the data…
        val date_text = intent.getStringExtra("date")
        val exp_text = intent.getStringExtra("explanation")
        val title_text = intent.getStringExtra("title")
        val image_text = intent.getStringExtra("image")


        explanation.text = exp_text
        date.text = date_text
        title.text = title_text
        Glide.with(this)
            .load(image_text) // image url
            .placeholder(R.drawable.logo) // any placeholder to load at start
            .error(R.drawable.ic_launcher_background)  // any image in case of error
            .override(200, 200) // resizing
            .centerCrop()
            .into(image);  // imageview object

        Log.d("cdfdf", "onCreate: " + date_text + exp_text + title_text + image_text)


    }


}
