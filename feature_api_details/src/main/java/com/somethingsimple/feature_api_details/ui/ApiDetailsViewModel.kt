package com.somethingsimple.feature_api_details.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.somethingsimple.core_api.common.plusAssign
import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.core_api.viewmodel.BaseViewModel
import com.somethingsimple.feature_api_details.domain.ApiDetailsUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ApiDetailsViewModel @Inject constructor(private val apisUseCase: ApiDetailsUseCase) :
    BaseViewModel() {

    private var current: ApiEntry? = null

    private val _detailsLiveData = MutableLiveData<ApiEntry>()

    val detailsLiveData: LiveData<ApiEntry>
        get() = _detailsLiveData


    fun getApi(link: String) {
        compositeDisposable +=
            apisUseCase.getApiForLink(link = link)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::postValue, ::onError, ::onComplete)
    }

    fun saveToFavourite() {
        current?.let {
            compositeDisposable += apisUseCase
                .saveToFavourite(it)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::postValue, ::onError, ::onComplete)
        }
    }

    private fun postValue(apiEntry: ApiEntry) {
        current = apiEntry
        _detailsLiveData.postValue(apiEntry)
    }

    private fun onError(throwable: Throwable) {
        Log.e("error", throwable.message.toString())
    }

    private fun onComplete() {
        Log.e("complete", "lol")
    }

}