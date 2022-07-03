package com.example.moviecatalogue.data.injection

import android.content.Context
import androidx.room.Room
import com.example.moviecatalogue.data.api.API
import com.example.moviecatalogue.data.local.DatabaseCatalogue
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object Injection {
    private val gson = GsonBuilder()
        .setLenient()
        .create()
    private val client = OkHttpClient()
    @Provides
    @Singleton
    fun retrofitProvides(): Retrofit = Retrofit.Builder()
        .baseUrl(API.URL_BASE)
        .client(client)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
    @Provides
    @Singleton
    fun apiProvides(retrofit: Retrofit): API = retrofit.create(API::class.java)
    @Provides
    @Singleton
    fun databaseProvides(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        DatabaseCatalogue::class.java,
        "db_catalogue"
    ).build()
}

