package com.piappstudio.offlineexam.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.piappstudio.offlineexam.common.Resource
import com.piappstudio.corelibrary.model.api.ExamRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (private  val examRepository: ExamRepository):ViewModel() {

    fun loadFromInternet() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        val dynamicUI = examRepository.home().body()
        if (dynamicUI!=null) {
            emit(Resource.success(dynamicUI))
        } else{
            emit(Resource.error(null, ""))
        }
    }
}