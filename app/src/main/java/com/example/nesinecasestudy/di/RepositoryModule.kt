package com.example.nesinecasestudy.di

import com.example.nesinecasestudy.data.repository.RepositoryImp
import com.example.nesinecasestudy.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindRepository(repository: RepositoryImp): Repository
}