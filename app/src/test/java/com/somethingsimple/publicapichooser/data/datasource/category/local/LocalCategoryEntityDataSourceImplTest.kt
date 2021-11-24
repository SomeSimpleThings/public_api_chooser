package com.somethingsimple.publicapichooser.data.datasource.category.local

import com.somethingsimple.core_api.data.db.CategoryDao
import com.somethingsimple.core_api.datasource.category.local.LocalCategoryDataSource
import com.somethingsimple.core_api.datasource.category.local.LocalCategoryDataSourceImpl
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class LocalCategoryEntityDataSourceImplTest {

    @Mock
    lateinit var categoryDao: CategoryDao

    lateinit var localCategoryDataSource: LocalCategoryDataSource

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        localCategoryDataSource = LocalCategoryDataSourceImpl(categoryDao)
    }

    @Test
    fun testGetCategory() {
//        val category = Category(1, "test")
//        whenever(categoryDao.getCategoryByName("test"))
//            .thenReturn(Single.just(category))
//
//        localCategoryDataSource.getCategory("test")
//            .test()
//            .assertResult(category)
//        verify(categoryDao, times(1)).getCategoryByName(category.name)
    }

    @Test
    fun testGetCategories() {
        whenever(categoryDao.getCategories())
            .thenReturn(Single.just(listOf()))
        localCategoryDataSource.getCategories()
            .test()
            .assertComplete()
        verify(categoryDao, times(1)).getCategories()
    }

    @Test
    fun testRetainOne() {
//        val category = Category(1, "test")
//        whenever(categoryDao.retain(category))
//            .thenReturn(Completable.complete())
//        whenever(categoryDao.getCategoryByName(category.name))
//            .thenReturn(Single.just(category))
//
//        localCategoryDataSource.retain(category)
//            .test()
//            .assertNoErrors()
//        verify(categoryDao, times(1)).retain(category)
//        verify(categoryDao, times(1)).getCategoryByName(category.name)
    }

    @Test
    fun testRetainMany() {
//        val categories = listOf(Category(1, "1"), Category(2, "2"))
//        whenever(categoryDao.getCategories())
//            .thenReturn(Single.just(categories))
//        whenever(categoryDao.retain(categories))
//            .thenReturn(Completable.complete())
//        localCategoryDataSource.retain(categories)
//            .test()
//            .assertComplete()
//            .assertComplete()
//        verify(categoryDao, times(1)).retain(categories)
//        verify(categoryDao, times(1)).getCategories()
    }
}