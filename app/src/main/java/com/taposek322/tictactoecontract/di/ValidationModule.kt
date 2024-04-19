package com.taposek322.tictactoecontract.di

import com.taposek322.tictactoecontract.domain.validation.ValidationClass
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ValidationModule {

    @Singleton
    @Provides
     fun bindValidationClass():ValidationClass{
        return ValidationClass()
    }
}