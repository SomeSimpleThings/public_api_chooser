package com.somethingsimple.publicapichooser.data.vo

import com.somethingsimple.core_api.data.vo.Category
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyLong
import org.mockito.ArgumentMatchers.anyString

class CategoryEntityTest {
    lateinit var category: Category

    @Before
    fun setUp() {
        category = Category( anyString())
    }
}