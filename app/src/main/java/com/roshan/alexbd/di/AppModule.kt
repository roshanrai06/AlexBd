package com.roshan.alexbd.di

import com.roshan.alexbd.data.APIService
import com.roshan.alexbd.data.BirthdayRepository
import com.roshan.alexbd.data.BirthdayRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideAPIService(): APIService {
        val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val client: OkHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(interceptor)
        }.build()
        return Retrofit.Builder()
            .baseUrl("https://mocki.io/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build().create(APIService::class.java)
    }

        @Provides
        fun providesVenuesRepository(apiService: APIService): BirthdayRepository {
            return BirthdayRepositoryImp(apiService)
        }

}