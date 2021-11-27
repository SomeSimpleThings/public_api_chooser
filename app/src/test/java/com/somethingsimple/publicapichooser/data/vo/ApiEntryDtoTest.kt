package com.somethingsimple.publicapichooser.data.vo

import com.somethingsimple.core_api.data.vo.ApiEntry
import org.junit.Before
import org.mockito.ArgumentMatchers.anyString

class ApiEntryDtoTest {
    lateinit var apiEntryHttps: ApiEntry
    lateinit var apiEntryHttp: ApiEntry

    @Before
    fun setUp() {
        apiEntryHttps = ApiEntry(
            anyString(),
            "",
            anyString(),
            "no",
            anyString(),
            true,
            "https://alexwohlbruck.github.io/cat-facts/",
        )
        apiEntryHttp = ApiEntry(
            "Colormind",
            "",
            "Art & Design",
            "unknown",
            "Color scheme generator",
            true,
            "http://colormind.io/api-access/",
        )
    }
}