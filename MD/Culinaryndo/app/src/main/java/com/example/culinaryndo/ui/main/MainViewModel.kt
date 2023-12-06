package com.example.culinaryndo.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.culinaryndo.data.model.LoginResult
import com.example.culinaryndo.data.repository.CulinaryndoRepository
import kotlinx.coroutines.launch
import java.io.File

class MainViewModel(private val repository: CulinaryndoRepository): ViewModel() {

    fun getSession(): LiveData<LoginResult> {
        return repository.getSession().asLiveData()
    }

    fun saveSession(user: LoginResult){
        viewModelScope.launch {
            repository.saveSession(user)
        }
    }

//    fun analyzeImage(imageFile: File) = repository.analyzeImage(imageFile)
}