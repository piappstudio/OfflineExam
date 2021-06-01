package com.piappstudio.corelibrary.model.di

import com.piappstudio.corelibrary.model.api.IExamApi
import com.piappstudio.corelibrary.model.api.IExamDataSource
import com.piappstudio.corelibrary.model.api.RemoteExamDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object ExamModule {

    @ViewModelScoped
    @Provides
    fun providedExamApi():IExamApi {
        return Retrofit.Builder()
            .baseUrl(IExamApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(IExamApi::class.java)
    }

    @ViewModelScoped
    @Provides
    fun providesExamDatasource(remoteExamDataSource: RemoteExamDataSource):IExamDataSource {
        return remoteExamDataSource
    }
}