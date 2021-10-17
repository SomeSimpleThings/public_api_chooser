package com.somethingsimple.publicapichooser.data.repository.category

import com.somethingsimple.publicapichooser.data.datasource.category.CategoryDataSource
import com.somethingsimple.publicapichooser.data.datasource.category.local.LocalCategoryDataSource
import com.somethingsimple.publicapichooser.data.datasource.category.local.LocalCategoryDataSourceImpl
import com.somethingsimple.publicapichooser.data.datasource.category.remote.RemoteCategoryDataSource
import com.somethingsimple.publicapichooser.data.vo.Category
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.never
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class CategoryRepositoryImplTest {
    lateinit var repo: CategoryRepository
    lateinit var remoteDataSource: CategoryDataSource
    lateinit var localDataSource: LocalCategoryDataSource

    lateinit var category1: Category
    lateinit var category2: Category
    lateinit var categoriesFromRemote: Single<List<Category>>
    lateinit var categoriesFromLocal: Single<List<Category>>

    @Before
    fun setUp() {
        category1 = Category(1, "category 1")
        category2 = Category(2, "category 2")

        categoriesFromLocal = Single.just(listOf(category1))
        categoriesFromRemote = Single.just(listOf(category1, category2))

        localDataSource = mock(LocalCategoryDataSourceImpl::class.java)
        remoteDataSource = mock(RemoteCategoryDataSource::class.java)

        repo = CategoryRepositoryImpl(remoteDataSource, localDataSource)

        whenever(localDataSource.getCategories()).thenReturn(categoriesFromLocal)
        whenever(remoteDataSource.getCategories()).thenReturn(categoriesFromRemote)
    }

    @Test
    fun ifLocalReturnedCategoriesRemoteNotCalled() {
        repo.getCategories()
        verify(remoteDataSource, never()).getCategories()
    }
//not working
    @Test
    fun ifLocalDoesNotReturnCategoriesThenRepositoryAsksToRemote() {
        whenever(localDataSource.getCategories()).thenReturn(Single.just(listOf()))
        val result = repo.getCategories().blockingGet()

        verify(localDataSource, times(1)).getCategories()
        verify(remoteDataSource, times(1)).getCategories()
    }
}