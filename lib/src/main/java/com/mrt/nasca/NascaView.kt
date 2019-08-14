package com.mrt.nasca

import android.annotation.TargetApi
import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.webkit.*

/**
 * Created by jaehochoe on 2019-07-16.
 */

open class NascaView @JvmOverloads constructor(
    context: Context? = null,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : WebView(context, attrs, defStyleAttr) {

    private var src: String? = null

    var zoomable: Boolean? = false
    var clickable: Boolean? = false
    var listener: NascaViewListener? = null

    init {
        attrs?.let {
            val a = context?.obtainStyledAttributes(attrs, R.styleable.NascaView)

            zoomable = a?.getBoolean(R.styleable.NascaView_nasca_zoomable, false)

            clickable = a?.getBoolean(R.styleable.NascaView_nasca_clickable, false)

            src = a?.getString(R.styleable.NascaView_nasca_src)

            a?.recycle()
        }

        super.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                return url?.let { onImageClicked(it) } ?: super.shouldOverrideUrlLoading(view, url)
            }

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return onImageClicked(request?.url.toString())
            }

            override fun onReceivedError(view: WebView?, errorCode: Int, description: String?, failingUrl: String?) {
                super.onReceivedError(view, errorCode, description, failingUrl)
                listener?.onLoadingFailed(failingUrl ?: "", errorCode, description)
            }

            @TargetApi(23)
            override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                super.onReceivedError(view, request, error)
                listener?.onLoadingFailed(request?.url.toString(), error?.errorCode ?: 0, error?.description)
            }

        })

        super.setWebChromeClient(object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                onProgressChanged(newProgress)
            }
        })

        settings.cacheMode = WebSettings.LOAD_DEFAULT
        settings.javaScriptEnabled = true

        src?.let {
            loadImages(it)
        }
    }

    fun loadImages(vararg sources: String) {
        loadImages(sources.toList())
    }

    fun loadImages(sources: Collection<String>) {
        nascaLoadImages(zoomable ?: false, sources) {
            val tags = StringBuilder()
            for ((i, source) in it.withIndex()) {
                tags.append(
                    String.format(
                        if (clickable == true) IMG_CLICKABLE_BR else IMG_NON_CLICKABLE_BR,
                        source,
                        i,
                        source
                    )
                )
            }
            tags.toString()
        }
    }

    private fun onImageClicked(url: String): Boolean {
        listener?.let {
            val uri = Uri.parse(url)
            if (uri.scheme == SCHEME && uri.host == ON_CLICKED) {
                it.onImageClicked(uri.getQueryParameter(INDEX)?.toInt() ?: -1, uri?.getQueryParameter(URL) ?: "")
                return true
            }
        }
        return false
    }

    private fun onProgressChanged(newProgrsss: Int) {
        listener?.onProgressChanged(newProgrsss)
    }

    @Deprecated("Not allowed")
    override fun setWebViewClient(client: WebViewClient?) {
    }

    @Deprecated("Not allowed")
    override fun setWebChromeClient(client: WebChromeClient?) {
    }
}
