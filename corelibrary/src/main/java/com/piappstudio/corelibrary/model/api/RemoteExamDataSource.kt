package com.piappstudio.corelibrary.model.api

import com.piappstudio.corelibrary.model.api.pojo.DynamicUI
import retrofit2.Response
import javax.inject.Inject

class RemoteExamDataSource @Inject constructor (private val examApi: IExamApi): IExamDataSource {
    override suspend fun home(): Response<DynamicUI> {
        return examApi.home()
    }
}