package com.ourfy.webtonative.userInterface.webView

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WebViewViewModel @Inject constructor() : ViewModel() {

    var currentUrl by mutableStateOf("")
        private set

    fun updateUrl(url: String) {
        currentUrl = url
    }

    fun clearUrl() {
        currentUrl = ""
    }
}
