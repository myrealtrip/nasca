package com.mrt.nasca

/**
 * Created by jaehochoe on 2019-07-16.
 */

const val SCHEME = "nasca"
const val ON_CLICKED = "onClicked"
const val INDEX = "index"
const val URL = "url"
const val BR = "<br>"
const val IMG_CLICKABLE =
    "<img src=\"%s\" onerror=\"this.style.display='none'\" onclick=\"javascript:location.href='$SCHEME://$ON_CLICKED?$INDEX=%s&$URL=%s'\"/>"
const val IMG_CLICKABLE_BR = "$IMG_CLICKABLE$BR"
const val IMG_NON_CLICKABLE =
    "<img src=\"%s\" onerror=\"this.style.display='none'\"/>"
const val IMG_NON_CLICKABLE_BR = "$IMG_NON_CLICKABLE$BR"
const val META_FOR_ZOOM =
    "<meta name=\"viewport\" content=\"user-scalable=yes, initial-scale=1.0, width=device-width, maximum-scale=9.0, minimum-scale=1.0\">"
const val STYLE = "<style>img{height: auto;max-width: 100%;}</style>"
const val HEAD = "<head>$STYLE</head>"
const val ZOOM_HEAD = "<head>$META_FOR_ZOOM$STYLE</head>"
const val BODY = "<body style='margin:0;padding:0;'>%s</body>"
const val MIME_TYPE = "text/html"
const val ENCODING = "utf-8"
