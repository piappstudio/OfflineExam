package com.piappstudio.corelibrary.model.api

import com.piappstudio.corelibrary.model.api.pojo.DynamicUI
import retrofit2.Response
import retrofit2.http.GET

interface IExamApi {
    companion object {
        const val BASE_URL ="https://private-8ce77c-tmobiletest.apiary-mock.com/"
    }
    @GET("test/home")
    suspend fun home(): Response<DynamicUI>
}