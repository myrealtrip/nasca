# Nasca

Nasca is high resolution image loading library for Android that wraps less memory usage, faster loading, caching, and easy to use callbacks. 

Nasca supports loading, displaying various type images from network including animated gif, webp. Nasca includes a lite API that using your own WebView as ImageView. Nasca's primary focus is on making scrolling HUGE size images as smooth and fast as possible without using app memory.

Download
-
You can use Gradle like this:

```
repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
    implementation 'com.github.myrealtrip:nasca:$version'
}
```

How do I use Nasca?
-
Check out the [sample app source code](/sample_app/src/main/java/com/mrt/nasca/sample) for the example.

Simple use cases will look something like this:

```
nascaView.loadImages(
    "https://github.com/comprohyo/images/blob/master/image5.jpg?raw=true",
    "https://github.com/comprohyo/images/blob/master/image7.jpg?raw=true"
)
```

Or this is also possible through using layout-xml.
```
<com.mrt.nasca.NascaView
    android:id="@+id/nasca"
    android:layout_width="match_parent"
    android:layout_height="match_parent"    
    app:nasca_zoomable="true"
    app:nasca_src="https://github.com/comprohyo/images/blob/master/image5.jpg?raw=true"
/>
```

If you need callback for click, progress, errors.
```
nascaView.listener = object : NascaViewListener() {
    override fun onImageClicked(index: Int, url: String) {
        super.onImageClicked(index, url)
        Log.d("onProgressChanged", "$index $url")
    }

    override fun onProgressChanged(progress: Int) {
        super.onProgressChanged(progress)
        Log.d("onProgressChanged", "$progress")
    }

    override fun onLoadingFailed(url: String, errorCode: Int, errorMsg: CharSequence?) {
        super.onLoadingFailed(url, errorCode, errorMsg)
        Log.d("onLoadingFailed", "$errorMsg $url")
    }
}
```

Or Use your own WebView as ImageView (Kotlin Only)
```
webView.nascaImageLoads(
    false, 
    "https://github.com/comprohyo/images/blob/master/image5.jpg?raw=true",
    "https://github.com/comprohyo/images/blob/master/image7.jpg?raw=true"
)
```

Compatibility
-

- Minimum Android SDK: Nasca requires a minimum API level of 21.
- Compile Android SDK: Nasca compiled SDK level 28.
