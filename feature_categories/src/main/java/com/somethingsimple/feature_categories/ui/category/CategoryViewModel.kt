package com.somethingsimple.feature_categories.ui.category

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.somethingsimple.core_api.data.vo.Category
import com.somethingsimple.feature_categories.domain.CategoryUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class CategoryViewModel @Inject constructor(val categoryUseCase: CategoryUseCase) : ViewModel() {

    val livedata = MutableLiveData<List<Category>>()

    fun getCategories() {
        categoryUseCase.getCats().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe(::loadCategories)

    }

    private fun loadCategories(category: List<Category>) {
        livedata.postValue(category)
    }
}