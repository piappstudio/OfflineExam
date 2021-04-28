package com.piappstudio.offlineexam.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.piappstudio.offlineexam.common.Resource
import com.piappstudio.offlineexam.model.data.ExamAPIService
import kotlinx.coroutines.Dispatchers

class MainViewModel:ViewModel() {

    fun loadFromInternet() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        val dynamicUI = ExamAPIService().examApi().home().body()
        if (dynamicUI!=null) {
            emit(Resource.success(dynamicUI))
        } else{
            emit(Resource.error(null, ""))
        }
    }
}