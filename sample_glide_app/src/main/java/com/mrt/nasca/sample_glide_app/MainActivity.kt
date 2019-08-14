package com.mrt.nasca.sample_glide_app

import android.databinding.DataBindingUtil
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import com.mrt.nasca.sample_glide_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val requestOptions = RequestOptions()
            .format(DecodeFormat.PREFER_ARGB_8888)
            .override(Target.SIZE_ORIGINAL)
        Glide.with(this)
            .applyDefaultRequestOptions(requestOptions)
            .load("https://github.com/myrealtrip/nasca/blob/master/photos/940x27000.jpg?raw=true")
            .into(binding.imageView1)
        Glide.with(this)
            .applyDefaultRequestOptions(requestOptions)
            .load("https://github.com/myrealtrip/nasca/blob/master/photos/940x27000.jpg?raw=true")
            .into(binding.imageView2)
    }
}


