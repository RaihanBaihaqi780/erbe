package com.example.erbe

import com.example.erbe.local.LocalRepository
import com.example.erbe.local.UserEntity
import com.example.erbe.remote.RemoteRepository

class AppRepository(private val localRepository: LocalRepository, private val remoteRepository: RemoteRepository){
    suspend fun insertUser(userEntity: UserEntity){
        localRepository.insertUser(userEntity)
    }

    suspend fun getUser(email:String, password:String):UserEntity {
        return localRepository.getUser(email, password)
    }

    suspend fun getGames() = remoteRepository.getGames()

}