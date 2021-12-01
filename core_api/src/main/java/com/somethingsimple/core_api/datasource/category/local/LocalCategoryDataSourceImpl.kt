package com.somethingsimple.core_api.datasource.category.local

import com.somethingsimple.core_api.data.db.CategoryDao
import com.somethingsimple.core_api.data.db.entity.CategoryEntity
import com.somethingsimple.core_api.data.vo.Category
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class LocalCategoryDataSourceImpl @Inject constructor(private val categoryDao: CategoryDao) :
    LocalCategoryDataSource {

    override fun save(categories: List<Category>): Completable {
        return categoryDao
            .save(categories.map { category -> CategoryEntity(0, category.name) })
    }


    override fun save(category: Category): Completable {
        return categoryDao
            .save(CategoryEntity(0, category.name))
    }


    override fun saveAndGet(categories: List<Category>): Flowable<List<Category>> {
        return save(categories)
            .andThen(getCategories())
    }


    override fun saveAndGetCategory(category: Category): Single<Category> {
        return save(category)
            .andThen(getCategory(category.name))
    }


    override fun getCategories(): Flowable<List<Category>> {
        return categoryDao
            .getCategories()
            .map { categories ->
                categories.map { categoryEntity -> Category(categoryEntity) }
            }
    }


    override fun getCategory(name: String): Single<Category> {
        return categoryDao.getCategoryByName(name).map { category -> Category(category) }

    }

    companion object {
        private const val TAG = "LocalCategoryDataSource"
    }

}