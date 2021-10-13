package com.somethingsimple.publicapichooser.data.vo

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyLong
import org.mockito.ArgumentMatchers.anyString

class ApiEntryTest {
    lateinit var apiEntryHttps: ApiEntry
    lateinit var apiEntryHttp: ApiEntry

    @Before
    fun setUp() {
        apiEntryHttps = ApiEntry(
            anyLong(),
            anyString(),
            "",
            anyString(),
            "no",
            anyString(),
            true,
            "https://alexwohlbruck.github.io/cat-facts/",
        )
        apiEntryHttp = ApiEntry(
            anyLong(),
            "Colormind",
            "",
            "Art & Design",
            "unknown",
            "Color scheme generator",
            true,
            "http://colormind.io/api-access/",
        )
    }

    @Test
    fun whenHttpsThenStartsWithCorrect() {
        assertTrue(apiEntryHttps.isHttpsCorrect())
        assertFalse(apiEntryHttp.isHttpsCorrect())
    }
}