package com.workdev.example.di

import com.workdev.data.remote.ApiService
import com.workdev.data.repo.PostsRepoImpL
import com.workdev.domain.repo.PostsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    // step six
    @Provides
    fun provideRepo(apiService: ApiService) :PostsRepo{

        return PostsRepoImpL(apiService)
    }
}