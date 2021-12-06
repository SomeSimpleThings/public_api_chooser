package com.somethingsimple.feature_categories.ui.category

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.somethingsimple.core_api.common.plusAssign
import com.somethingsimple.core_api.viewmodel.BaseViewModel
import com.somethingsimple.feature_categories.domain.CategoryUseCase
import com.somethingsimple.feature_categories.domain.CategoryWithEntries
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class CategoryViewModel @Inject constructor(val categoryUseCase: CategoryUseCase) :
    BaseViewModel() {

    private val _apiLivedata = MutableLiveData<List<CategoryWithEntries>>()
    val apiLiveData: LiveData<List<CategoryWithEntries>>
        get() = _apiLivedata

    fun getCategories() {
        compositeDisposable += categoryUseCase.getCats()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                ::loadCategories,
                ::onError
            )

    }

    private fun onError(throwable: Throwable) {
        Log.e("Error", throwable.message.toString())
    }

    private fun loadCategories(category: List<CategoryWithEntries>) {
        _apiLivedata.postValue(category)
    }

}