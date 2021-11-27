package com.somethingsimple.feature_categories.domain

import com.somethingsimple.core_api.data.vo.Category
import com.somethingsimple.feature_categories.data.repo.CategoryRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CategoryUseCase @Inject constructor(private val categoryRepository: CategoryRepository) {

    fun getCats(): Single<List<Category>> {
        return categoryRepository.getCategories()
    }
}