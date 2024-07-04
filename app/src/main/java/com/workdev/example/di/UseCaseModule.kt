package com.workdev.example.di

import dagger.Module
import com.workdev.domain.repo.PostsRepo
import com.workdev.domain.usecase.GetPosts
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    // step seven
    @Provides
    fun ProvideUseCase(categoriesRepo: PostsRepo) :GetPosts{

        return GetPosts(categoriesRepo)

    }


}