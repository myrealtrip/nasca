package com.mrt.nasca.nasca.binding

import android.databinding.BindingAdapter
import com.mrt.nasca.NascaView

/**
 * Created by jaehochoe on 2019-07-16.
 */

@BindingAdapter("images")
fun NascaView.setImages(src: List<String>?) {
    src?.let { this.loadImages(it) }

}

@BindingAdapter("image")
fun NascaView.setImage(src: String?) {
    src?.let { this.loadImages(it) }

}
