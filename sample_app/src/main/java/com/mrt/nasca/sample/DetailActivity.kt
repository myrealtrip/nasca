package com.mrt.nasca.sample

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebSettings
import com.mrt.nasca.nascaLoadImage
import com.mrt.nasca.sample.databinding.ActivityDetailBinding

/**
 * Created by jaehochoe on 2019-07-17.
 */
class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityDetailBinding>(this, R.layout.activity_detail)
        intent.getStringExtra(IMAGE_URL)?.let { binding.webview.nascaLoadImage(true, it) } ?: finish()
    }
}