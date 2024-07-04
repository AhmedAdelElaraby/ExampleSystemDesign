package com.workdev.example.di


import com.workdev.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // step five
@Provides
@Singleton
fun provideOkHttp() : OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(20,TimeUnit.SECONDS)
        .readTimeout(20,TimeUnit.SECONDS)
        .build()





    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()








    @Provides
    @Singleton
    fun provideAPIService(retrofit: Retrofit): ApiService =retrofit.create(ApiService::class.java)



}