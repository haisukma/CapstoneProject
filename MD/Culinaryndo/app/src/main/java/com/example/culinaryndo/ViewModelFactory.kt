package com.example.culinaryndo

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.culinaryndo.data.repository.CulinaryndoRepository
import com.example.culinaryndo.di.Injection
import com.example.culinaryndo.ui.main.MainViewModel
import com.example.culinaryndo.ui.profile.ProfileViewModel

class ViewModelFactory(
    private val culinaryndoRepository: CulinaryndoRepository
) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(culinaryndoRepository) as T
            }
            modelClass.isAssignableFrom(ProfileViewModel::class.java) -> {
                ProfileViewModel(culinaryndoRepository) as T
            }
            else -> throw IllegalArgumentException("Unknow ViewModel Class: "+ modelClass.name)
        }
    }

    companion object {
        fun getInstance(context: Context): ViewModelFactory {
            return ViewModelFactory(
                Injection.provideCulinaryndoRepository(context),
            )
        }
    }

}