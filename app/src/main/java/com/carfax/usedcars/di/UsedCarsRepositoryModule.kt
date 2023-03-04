package com.carfax.usedcars.di

import com.carfax.usedcars.data.repository.IUsedCarsRepository
import com.carfax.usedcars.data.repository.UsedCarsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UsedCarsRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindUsedCarsRepository(usedCarsRepositoryImpl: UsedCarsRepositoryImpl): IUsedCarsRepository

}