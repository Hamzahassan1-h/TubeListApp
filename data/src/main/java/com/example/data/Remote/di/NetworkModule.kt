package com.example.data.Remote.di

import com.example.data.service.TubeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient
        .Builder().apply {
            this.addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }
        .build()
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.tfl.gov.uk/Line/Mode/Tube/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    @Provides
    fun provideCapsuleService(retrofit: Retrofit):  TubeService =
        retrofit.create(TubeService::class.java)
}