package com.somethingsimple.feature_api_list.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.somethingsimple.core_api.common.plusAssign
import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.core_api.viewmodel.BaseViewModel
import com.somethingsimple.feature_api_list.domain.ApisUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ApisViewModel @Inject constructor(
    private val apisUseCase: ApisUseCase
) : BaseViewModel() {
    private val _apiLiveData = MutableLiveData<List<ApiEntry>>()

    val apiLiveData: LiveData<List<ApiEntry>>
        get() = _apiLiveData

    fun getApisForCategory(category: String) {
        compositeDisposable += apisUseCase.getApiForCategory(category)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::postApis)

    }

    private fun postApis(apis: List<ApiEntry>) {
        _apiLiveData.postValue(apis)
    }

}