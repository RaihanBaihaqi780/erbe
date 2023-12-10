package com.example.erbe.di

import com.example.erbe.remote.ApiService
import com.example.erbe.utils.Constant.BASE_URL
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule= module {
    single {
        OkHttpClient.Builder()
            .connectTimeout(60L,TimeUnit.SECONDS)
            .readTimeout(60L,TimeUnit.SECONDS)
            .writeTimeout(60L,TimeUnit.SECONDS)
            .build()
    }
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }
    single {
        createApiService<ApiService>(get())
    }
}
inline fun <reified T> createApiService(retrofit: Retrofit):T = retrofit.create(T::class.java)
