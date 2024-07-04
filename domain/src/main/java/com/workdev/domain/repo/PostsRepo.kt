package com.workdev.domain.repo

import com.workdev.domain.entity.PostResponse
import kotlinx.coroutines.flow.Flow

interface PostsRepo {

    // step two
    suspend fun getPostFromRemote() : Flow<PostResponse>

}