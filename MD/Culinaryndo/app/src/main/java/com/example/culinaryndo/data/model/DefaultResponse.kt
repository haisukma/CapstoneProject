package com.example.culinaryndo.data.model

import com.google.gson.annotations.SerializedName

data class DefaultResponse(

    @field:SerializedName("error")
    val error: Boolean? = null,

    @field:SerializedName("message")
    val message: String? = null
)
