package com.example.culinaryndo.di

import android.content.Context
import com.example.culinaryndo.data.network.ApiConfig
import com.example.culinaryndo.data.pref.UserPreference
import com.example.culinaryndo.data.pref.dataStore
import com.example.culinaryndo.data.repository.CulinaryndoRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

object Injection {
   fun provideCulinaryndoRepository(context: Context): CulinaryndoRepository {
       val pref = UserPreference.getInstance(context.dataStore)
       val user = runBlocking { pref.getSession().first() }
       val apiService = ApiConfig.getApiServices()
       return CulinaryndoRepository(pref,apiService)
   }
}
