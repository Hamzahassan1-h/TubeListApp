package com.example.data.Remote.di

import com.example.data.Repo.RemoteTubeDataSource
import com.example.data.source.RemoteTubeDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {
    @Binds
    abstract fun bindTubeInfoDataSource(
        dataSource: RemoteTubeDataSourceImpl
    ): RemoteTubeDataSource

}