package com.workdev.domain.usecase

import com.workdev.domain.repo.PostsRepo

class GetPosts(private val posts: PostsRepo) {

    // step three
    suspend operator fun invoke() = posts.getPostFromRemote()

}