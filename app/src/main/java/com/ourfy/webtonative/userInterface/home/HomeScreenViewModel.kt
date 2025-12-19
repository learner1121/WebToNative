package com.ourfy.webtonative.userInterface.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ourfy.webtonative.data.local.dao.UrlHistoryDao
import com.ourfy.webtonative.data.local.entity.UrlHistoryEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dao: UrlHistoryDao
) : ViewModel() {

    var urlText by mutableStateOf("")
        private set

    fun onUrlChange(text: String) {
        urlText = text
    }

    fun saveUrl(url: String) {
        viewModelScope.launch {
            dao.insertUrl(
                UrlHistoryEntity(
                    url = url,
                    timestamp = System.currentTimeMillis()
                )
            )
        }
    }
}
