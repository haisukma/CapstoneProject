package com.example.culinaryndo.data.repository

import com.example.culinaryndo.data.model.LoginResult
import com.example.culinaryndo.data.network.ApiServices
import com.example.culinaryndo.data.pref.UserPreference
import kotlinx.coroutines.flow.Flow

class CulinaryndoRepository(
    private val userPreference: UserPreference,
    private val apiService: ApiServices
) {
    fun getSession(): Flow<LoginResult> {
        return userPreference.getSession()
    }

    suspend fun saveSession(user: LoginResult){
        userPreference.saveSession(user)
    }

    suspend fun logout(){
        userPreference.logout()
    }
}