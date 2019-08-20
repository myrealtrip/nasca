# Nasca

Nasca is a high resolution image loading library using WebView for Android that enables less memory usage, faster loading, caching, and easier callbacks.

Nasca supports loading and displaying various types of images from networks that contain animated gifs and webp. Nasca includes a lite API that using your own WebView as ImageView. Nasca’s primary focus is to guarantee scrolling HUGE size images as smooth as possible without using too much app memory.

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
        Log.d("onImageClicked", "$index $url")
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

License
-

```
The MIT License (MIT)

Copyright (c) 2019 Myrealtrip

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

