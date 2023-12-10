package com.example.erbe.remote

import com.example.erbe.remote.response.Movie
import com.example.erbe.utils.Constant.API_KEY
import com.example.erbe.utils.Constant.GAMES_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(GAMES_ENDPOINT)
    suspend fun getGames(@Query("api_key") key: String = API_KEY
    ): Response<Movie>
//        @Query("api_key")apiKey: String = API_KEY) : Response<GamesResponse>

}