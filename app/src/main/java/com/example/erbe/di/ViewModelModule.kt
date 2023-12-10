package com.example.erbe.di

import com.example.erbe.ui.home.HomeViewModel
import com.example.erbe.ui.login.LoginViewModel
import com.example.erbe.ui.register.RegisterViewModel
import org.koin.dsl.module

val viewModel = module {
    single { LoginViewModel(get()) }
    single { RegisterViewModel(get()) }
    single { HomeViewModel(get()) }
}


