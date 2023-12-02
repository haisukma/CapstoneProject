package com.example.culinaryndo.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.culinaryndo.data.model.LoginResult
import com.example.culinaryndo.data.repository.CulinaryndoRepository
import kotlinx.coroutines.launch

class MainViewModel(private val culinaryndoRepository: CulinaryndoRepository): ViewModel() {

    fun getSession(): LiveData<LoginResult> {
        return culinaryndoRepository.getSession().asLiveData()
    }

    fun saveSession(user: LoginResult){
        viewModelScope.launch {
            culinaryndoRepository.saveSession(user)
        }
    }

    fun logout(){
        viewModelScope.launch {
            culinaryndoRepository.logout()
        }
    }
}