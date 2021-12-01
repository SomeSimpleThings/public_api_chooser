package com.somethingsimple.feature_categories.domain

import com.somethingsimple.core_api.data.vo.Category
import com.somethingsimple.feature_categories.data.repo.CategoryRepository
import com.somethingsimple.feature_categories.data.repo.PublicApiRepository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CategoryUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository,
    private val publicApiRepository: PublicApiRepository
) {

    fun getCats(): Single<List<CategoryWithEntries>> {

        return publicApiRepository
            .getCategories()
            .flattenAsObservable { it }
            .flatMap(::getItemsForCategory)
            .toList()

    }

    private fun getItemsForCategory(category: Category): Observable<CategoryWithEntries> {
        return publicApiRepository
            .getPublicApiForCategory(categoryName = category.name, 5)
            .map { list -> CategoryWithEntries(category, list) }
            .toObservable()
    }
}