package com.mrt.nasca.sample_glide_app

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by jaehochoe on 2019-07-25.
 */
class Adapter : RecyclerView.Adapter<ViewHolder>() {

    private val sources = listOf(
        "https://github.com/myrealtrip/nasca/blob/master/photos/gold_california_beach_set.jpg?raw=true"
    )

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_list, viewGroup, false))
    }

    override fun getItemCount(): Int {
        return sources.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(sources[position])
    }
}
