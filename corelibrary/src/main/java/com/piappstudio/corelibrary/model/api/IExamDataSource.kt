package com.piappstudio.corelibrary.model.api

import com.piappstudio.corelibrary.model.api.pojo.DynamicUI
import retrofit2.Response

interface IExamDataSource {
    suspend fun home(): Response<DynamicUI>
}