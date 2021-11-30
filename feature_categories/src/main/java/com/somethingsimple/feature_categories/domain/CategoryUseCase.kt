package com.somethingsimple.feature_categories.domain

import com.somethingsimple.core_api.data.vo.Category
import com.somethingsimple.feature_categories.data.repo.CategoryRepository
import com.somethingsimple.feature_categories.data.repo.PublicApiRepository
import io.reactivex.rxjava3.core.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class CategoryUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository,
    private val publicApiRepository: PublicApiRepository
) {

    fun getCats(): Single<List<CategoryWithEntries>> {
        return categoryRepository
            .getCategories()
            .flatMap { list ->
                val cats = list.map { category -> getItemsForCategory(category) }
                return@flatMap Single.zip(cats) {
                    it.toList() as List<CategoryWithEntries>
                }
            }


    }

    private fun getItemsForCategory(category: Category): Single<CategoryWithEntries> {
        return publicApiRepository
            .getPublicApiForCategory(categoryName = category.name)
            .delay(3, TimeUnit.SECONDS)
            .map { list -> CategoryWithEntries(category, list) }
    }
}