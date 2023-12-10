package com.example.erbe.di


import com.example.erbe.AppRepository
import com.example.erbe.local.LocalRepository
import com.example.erbe.remote.RemoteRepository
import org.koin.dsl.module

val respositoryModule = module{
    single {LocalRepository(get())}
    single { RemoteRepository (get()) }
    single { AppRepository(get(), get()) }

}
