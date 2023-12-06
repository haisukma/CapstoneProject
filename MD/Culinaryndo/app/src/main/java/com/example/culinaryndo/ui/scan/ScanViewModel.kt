package com.example.culinaryndo.ui.scan

import androidx.camera.core.ImageCapture
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.culinaryndo.data.repository.CulinaryndoRepository

class ScanViewModel(private val repository: CulinaryndoRepository): ViewModel() {
   val flashMode =  MutableLiveData<Int>()

   init {
       flashMode.value = ImageCapture.FLASH_MODE_OFF
   }
}