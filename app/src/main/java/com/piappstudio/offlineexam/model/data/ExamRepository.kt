package com.piappstudio.offlineexam.model.data

import com.piappstudio.offlineexam.model.api.IExamApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ExamRepository {
    private fun retrofit():Retrofit {
       return Retrofit.Builder()
            .baseUrl(IExamApi.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }
    fun examApi():IExamApi {
        return retrofit().create(IExamApi::class.java)
    }
}