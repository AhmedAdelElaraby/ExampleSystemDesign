package com.workdev.domain.usecase

import com.workdev.domain.entity.PostResponse
import com.workdev.domain.repo.PostsRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetPosts(private val posts: PostsRepo) {

    // step three
    suspend operator fun invoke() = flow<PostResponse> {
        emit(posts.getPostFromRemote())
    }.flowOn(Dispatchers.IO)


}