package com.audiobooks.networking.di

import com.audiobooks.networking.BuildConfig
import com.audiobooks.networking.PodcastsApi
import com.audiobooks.networking.interceptor.OkHttpInterceptor
import com.audiobooks.networking.repository.PodcastsRepository
import com.audiobooks.networking.repository.PodcastsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object NetworkModule {

    @Provides
    @Singleton
    fun providesOkHttpInterceptor(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(OkHttpInterceptor())
            .build()

    @Provides
    @Singleton
    fun providesPodcastsApi(okHttpClient: OkHttpClient): PodcastsApi =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.PODCASTS_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PodcastsApi::class.java)

    @Provides
    @Singleton
    fun providesPodcastsRepository(
        podcastsApi: PodcastsApi,
    ): PodcastsRepository =
        PodcastsRepositoryImpl(
            podcastsApi,
        )
}