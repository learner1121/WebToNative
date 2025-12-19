package com.ourfy.webtonative.userInterface.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ourfy.webtonative.data.local.dao.UrlHistoryDao
import com.ourfy.webtonative.data.remote.api.UploadApi
import com.ourfy.webtonative.data.remote.model.UploadItem
import com.ourfy.webtonative.data.remote.model.UploadRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val dao: UrlHistoryDao,
    private val api: UploadApi
) : ViewModel() {

    val history = dao.getAllUrls()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun clearAll() {
        viewModelScope.launch {
            dao.deleteAll()
        }
    }

    fun uploadHistory() {
        viewModelScope.launch {
            val request = UploadRequest(
                data = history.value.map {
                    UploadItem(it.url, it.timestamp)
                }
            )
            api.uploadHistory(request)
        }
    }
}
