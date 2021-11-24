package com.somethingsimple.publicapichooser.ui.category

import com.somethingsimple.core_api.data.vo.Category
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.atMost
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class CategoryEntityListPresenterTest {

    lateinit var categoryListPresenter: CategoryListPresenter

    @Mock
    lateinit var view: CategoryItemView

    lateinit var categories: List<Category>

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        categoryListPresenter = CategoryListPresenter()
        categories = listOf(
            Category("1"),
            Category("2"),
            Category("3")
        )
    }

    @Test
    fun addAll() {
        categoryListPresenter.addAll(categories)
        Assert.assertEquals(categoryListPresenter.categories, categories)
    }

    @Test
    fun getCount() {
        categoryListPresenter.addAll(categories)
        Assert.assertEquals(categoryListPresenter.getCount(), categories.size)
    }

    @Test
    fun getCountNoElements() {
        val categories = listOf<Category>()
        categoryListPresenter.addAll(categories)
        assert(categoryListPresenter.categories.size == 0)
    }

    @Test
    fun getItemAtPosReturnCorrect() {
        categoryListPresenter.addAll(categories)
        Assert.assertEquals(categories[2], categoryListPresenter.getItemAtPos(2))
    }

    @Test
    fun getItemAtPosReturnNullIfIndexMoreThanElements() {
        categoryListPresenter.addAll(categories)
        Assert.assertNull(categoryListPresenter.getItemAtPos(4))
    }

    @Test
    fun clear() {
        categoryListPresenter.addAll(categories)
        categoryListPresenter.clear()
        assert(categoryListPresenter.categories.isEmpty())
    }

    @Test
    fun bindView() {

        categoryListPresenter.addAll(categories)
        whenever(view.pos).thenReturn(2)
        categoryListPresenter.bindView(view)
        verify(view, atMost(1)).bind(categories[2])
    }
}