package com.somethingsimple.core_api.datasource.category.local

import com.somethingsimple.core_api.data.db.CategoryDao
import com.somethingsimple.core_api.data.db.entity.CategoryEntity
import com.somethingsimple.core_api.data.vo.Category
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class LocalCategoryDataSourceImpl @Inject constructor(private val categoryDao: CategoryDao) :
    LocalCategoryDataSource {


    override fun retain(categories: List<Category>): Single<List<Category>> =
        categoryDao
            .retain(categories.map { category -> CategoryEntity(0, category.name) })
            .andThen(getCategories())


    override fun retain(category: Category): Single<Category> =
        categoryDao
            .retain(CategoryEntity(0, category.name))
            .andThen(getCategory(category.name))


    override fun getCategories(): Single<List<Category>> =
        categoryDao
            .getCategories()
            .map { categories ->
                categories.map { categoryEntity -> Category(categoryEntity) }
            }

    override fun getCategory(name: String): Single<Category> =
        categoryDao.getCategoryByName(name).map { category -> Category(category) }

}