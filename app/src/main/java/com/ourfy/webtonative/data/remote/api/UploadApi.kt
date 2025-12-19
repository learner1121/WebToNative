package com.ourfy.webtonative.data.remote.api

import com.ourfy.webtonative.data.remote.model.UploadRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UploadApi {

    @POST("upload")
    suspend fun uploadHistory(
        @Body request: UploadRequest
    ): Response<Unit>
}
