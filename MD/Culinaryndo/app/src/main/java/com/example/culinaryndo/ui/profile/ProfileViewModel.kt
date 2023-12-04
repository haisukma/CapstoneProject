package com.example.culinaryndo.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.culinaryndo.data.repository.CulinaryndoRepository
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: CulinaryndoRepository): ViewModel() {
    fun logout(){
        viewModelScope.launch {
            repository.logout()
        }
    }
}