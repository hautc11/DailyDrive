package com.minimalistcraft.android.data.di

import com.minimalistcraft.android.data.repository.HabitRepositoryImpl
import com.minimalistcraft.android.domain.repository.IHabitRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindHabitRepository(
        habitRepositoryImpl: HabitRepositoryImpl
    ): IHabitRepository
}