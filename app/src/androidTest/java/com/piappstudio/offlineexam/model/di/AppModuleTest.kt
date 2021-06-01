package com.piappstudio.offlineexam.model.di

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.piappstudio.corelibrary.model.api.IExamApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@RunWith(AndroidJUnit4::class)
class AppModuleTest {

    @Test
    fun testApi() = runBlocking {
        val retrofit = Retrofit.Builder()
            .baseUrl(IExamApi.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

        val dynamicUI = retrofit.create(IExamApi::class.java).home()
        assertTrue(dynamicUI.body()?.page?.cards?.size?.compareTo(0)==1)
    }

}