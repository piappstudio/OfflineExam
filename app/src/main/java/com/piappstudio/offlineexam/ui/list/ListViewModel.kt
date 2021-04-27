package com.piappstudio.offlineexam.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.piappstudio.offlineexam.model.pojo.Page

class ListViewModel:ViewModel() {
    private var _pageInfo:MutableLiveData<Page> = MutableLiveData()
    val livePageInfo:LiveData<Page> = _pageInfo
    fun postPageInfo(page:Page?) {
        page?.let {
            _pageInfo.postValue(it)
        }

    }
}