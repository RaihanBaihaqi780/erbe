package com.example.erbe.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.erbe.AppRepository
import com.example.erbe.remote.response.Movie
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel(private val appRepository: AppRepository): ViewModel() {
    val getGames = MutableLiveData<Response<Movie>>()
    val observeGames: LiveData<Response<Movie>> = getGames

    fun getGame(){
        viewModelScope.launch {
            try {
                val result = appRepository.getGames()
                getGames.postValue(result)
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

}