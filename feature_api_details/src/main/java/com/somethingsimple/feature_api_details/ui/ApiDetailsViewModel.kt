package com.somethingsimple.feature_api_details.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.feature_api_details.domain.ApiDetailsUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ApiDetailsViewModel @Inject constructor(private val apisUseCase: ApiDetailsUseCase) :
    ViewModel() {

    val liveData = MutableLiveData<ApiEntry>()

    fun getApi(name: String) {
        apisUseCase.getApiForName(name = name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::postValue)
    }

    private fun postValue(apiEntry: ApiEntry) {
        liveData.postValue(apiEntry)
    }
}