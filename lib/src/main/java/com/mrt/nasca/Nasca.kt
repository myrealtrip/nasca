package com.mrt.nasca

import android.webkit.WebView

/**
 * Created by jaehochoe on 2019-07-17.
 */

fun WebView.nascaLoadImage(source: String) {
    nascaLoadImage(false, source)
}

fun WebView.nascaLoadImage(zoomable: Boolean = false, source: String) {
    nascaLoadImages(zoomable, source)
}

fun WebView.nascaLoadImages(zoomable: Boolean = false, vararg sources: String) {
    nascaLoadImages(zoomable, sources.toList()) {
        val tags = StringBuilder()
        for ((i, source) in it.withIndex()) {
            tags.append(String.format(IMG_NON_CLICKABLE_BR, source, i, source))
        }
        tags.toString()
    }
}

fun WebView.nascaLoadImages(zoomable: Boolean = false, sources: Collection<String>, block: (Array<String>) -> String) {
    if (zoomable && (!settings.supportZoom() || !settings.builtInZoomControls || !settings.loadWithOverviewMode || !settings.useWideViewPort)) usingZoom()
    val header = when (zoomable) {
        true ->
            ZOOM_HEAD
        false ->
            HEAD
    }
    loadData("$header${String.format(BODY, block(sources.toTypedArray()))}", MIME_TYPE, ENCODING)
}

fun WebView.usingZoom() {
    settings.setSupportZoom(true)
    settings.builtInZoomControls = true
    settings.displayZoomControls = false
    settings.loadWithOverviewMode = true
    settings.useWideViewPort = true
}