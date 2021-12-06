package com.somethingsimple.feature_api_details.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.feature_api_details.domain.ApiDetailsUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ApiDetailsViewModel @Inject constructor(private val apisUseCase: ApiDetailsUseCase) :
    ViewModel() {

    private var current: ApiEntry? = null

    val liveData = MutableLiveData<ApiEntry>()

    fun getApi(link: String) {
        apisUseCase.getApiForLink(link = link)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::postValue, ::onError, ::onComplete)
    }

    private fun postValue(apiEntry: ApiEntry) {
        current = apiEntry
        liveData.postValue(apiEntry)
    }

    private fun onError(throwable: Throwable) {
        Log.e("error", throwable.message.toString())
    }

    private fun onComplete() {
        Log.e("complete", "lol")
    }

    fun saveToFavourite() {
        current?.let {
            apisUseCase
                .saveToFavourite(it)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::postValue, ::onError, ::onComplete)
        }
    }
}