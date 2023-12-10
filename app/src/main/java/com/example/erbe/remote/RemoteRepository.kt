package com.example.erbe.remote



class RemoteRepository(private val apiService: ApiService) {
    suspend fun getGames() = apiService.getGames()
}