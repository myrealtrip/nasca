package com.mrt.nasca.sample_glide_app

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.mrt.nasca.sample_glide_app.databinding.ItemListBinding

/**
 * Created by jaehochoe on 2019-07-25.
 */
class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var binding: ItemListBinding? = null

    init {
        binding = DataBindingUtil.bind(itemView)
    }

    fun onBind(url: String) {
        binding?.let {
            val requestOptions = RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)
            Glide.with(itemView.context)
                .apply { requestOptions }
                .load(url)
                .into(it.imageView)
        }
    }
}