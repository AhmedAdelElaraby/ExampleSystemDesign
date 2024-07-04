package com.workdev.data.repo

import com.workdev.data.remote.ApiService
import com.workdev.domain.entity.PostResponse
import com.workdev.domain.repo.PostsRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PostsRepoImpL(private val apiService: ApiService):PostsRepo {

        // step fore
    override suspend fun getPostFromRemote() : Flow<PostResponse> = flow {

            emit(apiService.getPosts())

        }.flowOn(Dispatchers.IO)








}