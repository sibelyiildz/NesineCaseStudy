package com.example.nesinecasestudy.di

import android.content.Context
import com.example.nesinecasestudy.BuildConfig
import com.example.nesinecasestudy.data.remote.RemoteDataSource
import com.example.nesinecasestudy.data.remote.RemoteDataSourceImp
import com.example.nesinecasestudy.data.remote.service.Api
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModule {

    companion object {
        @Provides
        @Singleton
        fun provideGson(): Gson {
            return GsonBuilder().create()
        }

        @Provides
        @Singleton
        fun provideOkHttpClient(
            @ApplicationContext context: Context
        ): OkHttpClient {
            return OkHttpClient().newBuilder()
                .connectTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
        }

        @Provides
        @Singleton
        fun provideRetrofit(
            okHttpClient: OkHttpClient,
            gson: Gson
        ): Retrofit {
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }

        @Provides
        @Singleton
        fun provideApi(
            retrofit: Retrofit
        ): Api {
            return retrofit.create()
        }
    }

    @Binds
    @Singleton
    fun bindRemoteDataSource(remoteDataSourceImp: RemoteDataSourceImp): RemoteDataSource

}