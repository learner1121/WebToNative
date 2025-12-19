package com.ourfy.webtonative.navigation


sealed class Routes(val route: String) {
    object Home : Routes("home")
    object WebView : Routes("webview/{url}") {
        fun passUrl(url: String) = "webview/$url"
    }
    object History : Routes("history")
}
