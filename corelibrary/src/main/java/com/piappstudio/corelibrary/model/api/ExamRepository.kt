package com.piappstudio.corelibrary.model.api

import com.piappstudio.corelibrary.model.api.pojo.DynamicUI
import retrofit2.Response
import javax.inject.Inject

class ExamRepository @Inject constructor (private val examDataSource: IExamDataSource) {
    suspend fun home(): Response<DynamicUI> = examDataSource.home()
}