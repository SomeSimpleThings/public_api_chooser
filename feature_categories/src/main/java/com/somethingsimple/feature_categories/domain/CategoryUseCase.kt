package com.somethingsimple.feature_categories.domain

import com.somethingsimple.core_api.data.vo.Category
import com.somethingsimple.feature_categories.data.repo.CategoryRepository
import com.somethingsimple.feature_categories.data.repo.PublicApiRepository
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class CategoryUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository,
    private val publicApiRepository: PublicApiRepository
) {

    fun getCats(): Flowable<List<CategoryWithEntries>> {
        return categoryRepository
            .getCategories()
            .map { it -> it.map { CategoryWithEntries(it, listOf()) } }
//            .flatMap { list ->
//                list.map { ) }
//            }
//            .flatMap { list ->
//                return@flatMap Flowable.concat( list.map { category -> getItemsForCategory(category) })
////                return@flatMap Single.zip(cats) {
////                    it.toList() as List<CategoryWithEntries>
////                }
//            }


    }

    private fun getItemsForCategory(category: Category): Flowable<CategoryWithEntries> {
        return publicApiRepository
            .getPublicApiForCategory(categoryName = category.name, 5)
            .map { list -> CategoryWithEntries(category, list) }
    }
}