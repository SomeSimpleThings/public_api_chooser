package com.somethingsimple.feature_api_list.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.feature_api_list.domain.ApisUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ApisViewModel @Inject constructor(private val apisUseCase: ApisUseCase) : ViewModel() {
    val livedata = MutableLiveData<List<ApiEntry>>()

    fun getApisForCategory(category: String) {
        apisUseCase.getApiForCategory(category).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe(::postApis)

    }

    private fun postApis(apis: List<ApiEntry>) {
        livedata.postValue(apis)
    }

}