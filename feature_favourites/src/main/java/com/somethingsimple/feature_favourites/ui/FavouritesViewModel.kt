package com.somethingsimple.feature_favourites.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.somethingsimple.core_api.common.plusAssign
import com.somethingsimple.core_api.data.vo.ApiEntry
import com.somethingsimple.core_api.viewmodel.BaseViewModel
import com.somethingsimple.feature_favourites.domain.FavouritesUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class FavouritesViewModel @Inject constructor(
    private val favouritesUseCase: FavouritesUseCase
) :
    BaseViewModel() {

    private val _favouritesLiveData = MutableLiveData<List<ApiEntry>>()
    val favouritesLiveData: LiveData<List<ApiEntry>>
        get() = _favouritesLiveData

    fun getFavourites() {
        compositeDisposable +=
            favouritesUseCase
                .getFavourites()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::onLoaded, ::onError, ::onComplete)

    }

    private fun onLoaded(favourites: List<ApiEntry>) {
        _favouritesLiveData.postValue(favourites)
    }

    private fun onError(throwable: Throwable) {}

    private fun onComplete() {
        Log.e("xxx", "complete")
    }
}