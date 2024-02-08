package com.muratozcan.contactsapp.di

import com.muratozcan.contactsapp.data.datasource.PersonsDataSource
import com.muratozcan.contactsapp.data.repo.PersonsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providePersonsDataSource() : PersonsDataSource {
        return PersonsDataSource()
    }

    @Provides
    @Singleton
    fun providePersonsRepository(pds: PersonsDataSource) : PersonsRepository {
        return PersonsRepository(pds)
    }
}