package com.carfax.usedcars.di

import com.carfax.usedcars.preferences.IPreferences
import com.carfax.usedcars.preferences.PreferencesImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PreferencesModule {

    @Binds
    @Singleton
    abstract fun bindPreferences(preferencesImpl: PreferencesImpl): IPreferences
}