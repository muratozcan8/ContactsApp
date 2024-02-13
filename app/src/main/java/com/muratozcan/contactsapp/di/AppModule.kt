package com.muratozcan.contactsapp.di

import android.content.Context
import androidx.room.Room
import com.muratozcan.contactsapp.data.datasource.PersonsDataSource
import com.muratozcan.contactsapp.data.repo.PersonsRepository
import com.muratozcan.contactsapp.room.Database
import com.muratozcan.contactsapp.room.PersonsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providePersonsDataSource(pdao: PersonsDao) : PersonsDataSource {
        return PersonsDataSource(pdao)
    }

    @Provides
    @Singleton
    fun providePersonsRepository(pds: PersonsDataSource) : PersonsRepository {
        return PersonsRepository(pds)
    }

    @Provides
    @Singleton
    fun providePersonsDao(@ApplicationContext context: Context) : PersonsDao {
        val db = Room.databaseBuilder(context, Database::class.java, "Contacts.db").createFromAsset("Contacts.db").build()
        return db.getPersonsDao()
    }
}