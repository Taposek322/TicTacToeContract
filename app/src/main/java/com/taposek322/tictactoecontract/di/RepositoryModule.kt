package com.taposek322.tictactoecontract.di

import com.taposek322.tictactoecontract.data.repository.EtherRepositoryImpl
import com.taposek322.tictactoecontract.domain.repository.EtherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindEtherRepository(etherRepositoryImpl: EtherRepositoryImpl): EtherRepository

}