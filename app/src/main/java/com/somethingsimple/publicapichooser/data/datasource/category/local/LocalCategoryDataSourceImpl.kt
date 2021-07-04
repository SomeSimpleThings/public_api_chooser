package com.somethingsimple.publicapichooser.data.datasource.category.local

import com.somethingsimple.publicapichooser.data.db.ApiChooserDb
import com.somethingsimple.publicapichooser.data.db.CategoryDao
import com.somethingsimple.publicapichooser.data.vo.Category
import io.reactivex.rxjava3.core.Single

class LocalCategoryDataSourceImpl(db: ApiChooserDb) : LocalCategoryDataSource {

    private val categoryDao: CategoryDao = db.categoriesDao()

    override fun retain(categories: List<Category>): Single<List<Category>> =
        categoryDao
            .retain(categories)
            .andThen(getCategories())


    override fun retain(category: Category): Single<Category> {
        TODO("Not yet implemented")
    }

    override fun getCategories(): Single<List<Category>> =
        categoryDao.getCategories()

}