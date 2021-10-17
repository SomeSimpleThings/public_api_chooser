package com.somethingsimple.publicapichooser.data.vo

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyLong
import org.mockito.ArgumentMatchers.anyString

class CategoryTest {
    lateinit var category: Category

    @Before
    fun setUp() {
        category = Category(anyLong(), anyString())
    }


    @Test
    fun testNameWithId() {
        val expected = "${category.id} ${category.name}"
        val categoryWithId = category.getNameWithId()
        assertEquals(expected, categoryWithId)
    }
}