package com.mrt.nasca.sample

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.webkit.WebView
import com.mrt.nasca.NascaViewListener
import com.mrt.nasca.nascaLoadImage
import com.mrt.nasca.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val sources = listOf(
        "https://github.com/myrealtrip/nasca/blob/master/photos/940x27000.jpg?raw=true"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WebView.setWebContentsDebuggingEnabled(true)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.nasca.listener = object : NascaViewListener() {
            override fun onImageClicked(index: Int, url: String) {
                Intent(this@MainActivity, DetailActivity::class.java).putExtra(IMAGE_URL, url)
                    .apply { startActivity(this) }
            }

            override fun onProgressChanged(progress: Int) {
                super.onProgressChanged(progress)
                binding.progress = progress
            }

            override fun onLoadingFailed(url: String, errorCode: Int, errorMsg: CharSequence?) {
                super.onLoadingFailed(url, errorCode, errorMsg)
                Log.d("onLoadingFailed", "$errorMsg $url")
            }
        }
        binding.sources = sources
    }
}
