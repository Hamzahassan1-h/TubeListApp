package com.example.tubelistapp.di

import com.example.data.Repo.RemoteTubeDataSource
import com.example.data.Repo.TubeRepositoryImpl
import com.example.domain.repo.TubeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun providesTubeRepository(
        remoteSource: RemoteTubeDataSource
    ): TubeRepository = TubeRepositoryImpl(
        remoteSource
    )
}