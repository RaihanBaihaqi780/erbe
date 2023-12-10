package com.example.erbe.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.erbe.AppRepository
import com.example.erbe.local.UserEntity
import kotlinx.coroutines.launch

class RegisterViewModel(private val appRepository: AppRepository): ViewModel() {
    private val isRegister = MutableLiveData<Boolean>()

    fun observeRegister(): LiveData<Boolean> = isRegister

    fun insertUser(user: UserEntity){
        viewModelScope.launch {
            try {
                appRepository.insertUser(user)
                isRegister.postValue(true)
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }

}