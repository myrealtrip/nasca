package com.mrt.nasca

/**
 * Created by jaehochoe on 2019-07-16.
 */
open class NascaViewListener {
    open fun onImageClicked(index: Int, url: String) {}
    open fun onProgressChanged(progress: Int) {}
    open fun onLoadingFailed(url: String, errorCode: Int, errorMsg: CharSequence?) {}
}