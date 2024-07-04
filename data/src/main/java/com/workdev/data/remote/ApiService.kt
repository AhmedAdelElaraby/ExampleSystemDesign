package com.workdev.data.remote

import com.workdev.domain.entity.PostResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {

    // step one
    @GET("posts")
    suspend fun getPosts(): PostResponse

}