package com.example.culinaryndo.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.culinaryndo.data.Result
import com.example.culinaryndo.data.model.DefaultResponse
import com.example.culinaryndo.data.model.LoginResult
import com.example.culinaryndo.data.network.ApiServices
import com.example.culinaryndo.data.pref.UserPreference
import com.example.culinaryndo.utils.reduceFileImage
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.HttpException
import java.io.File

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

//    fun analyzeImage(imageFile: File): LiveData<Result<DetailFoodResponse>> = liveData {
//        emit(Result.Loading)
//        try {
//            val imageFileReduce = imageFile.reduceFileImage()
//            val requestImageFile = imageFileReduce.asRequestBody("image/jpeg".toMediaType())
//            val multipartBody = MultipartBody.Part.createFormData(
//                "photo",
//                imageFile.name,
//                requestImageFile
//            )
//
//            val response = apiService.analyzeImage(multipartBody)
//            emit(Result.Success(response))
//        }catch(e: HttpException) {
//            val errorBody = e.response()?.errorBody()?.string()
//            val errorResponse = Gson().fromJson(errorBody, DefaultResponse::class.java)
//            emit(Result.Error(errorResponse.message.toString()))
//        }
//    }
}