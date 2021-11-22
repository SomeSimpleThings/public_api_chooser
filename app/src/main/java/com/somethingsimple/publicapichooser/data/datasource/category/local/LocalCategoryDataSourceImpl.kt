package com.somethingsimple.publicapichooser.data.datasource.category.local

import com.somethingsimple.publicapichooser.data.db.CategoryDao
import com.somethingsimple.publicapichooser.data.vo.Category
import io.reactivex.rxjava3.core.Single

class LocalCategoryDataSourceImpl(private val categoryDao: CategoryDao) : LocalCategoryDataSource {


    override fun retain(categories: List<Category>): Single<List<Category>> =
        categoryDao
            .retain(categories)
            .andThen(getCategories())


    override fun retain(category: Category): Single<Category> =
        categoryDao
            .retain(category)
            .andThen(getCategory(category.name))


    override fun getCategories(): Single<List<Category>> =
        categoryDao.getCategories()

    override fun getCategory(name: String): Single<Category> =
        categoryDao.getCategoryByName(name)

}