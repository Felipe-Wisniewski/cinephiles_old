package com.exemple.android.cinephilesapp.binding

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

object ImageBinding {

    @JvmStatic
    @BindingAdapter("app:imageUrl")
    fun setImageUrl(imageView: ImageView, url: String) {

        val completeUrl = "https://image.tmdb.org/t/p/w500$url"

        /*if (url != null) {
            completeUrl + url
        }*/

        Log.d("FLMWG", "IMGURL -> $completeUrl")

        Picasso.get()
            .load(completeUrl)
            .into(imageView)

    }
}