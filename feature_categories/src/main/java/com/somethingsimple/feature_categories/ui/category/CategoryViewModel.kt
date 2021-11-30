package com.somethingsimple.feature_categories.ui.category

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.somethingsimple.feature_categories.domain.CategoryUseCase
import com.somethingsimple.feature_categories.domain.CategoryWithEntries
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class CategoryViewModel @Inject constructor(val categoryUseCase: CategoryUseCase) : ViewModel() {

    val livedata = MutableLiveData<List<CategoryWithEntries>>()

    fun getCategories() {
        categoryUseCase.getCats().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                ::loadCategories,
                ::onError
            )

    }

    private fun onError(throwable: Throwable) {
        throwable.message?.let { Log.e("Error", it) }
    }

    private fun loadCategories(category: List<CategoryWithEntries>) {
        livedata.postValue(category)
    }

}