package com.somethingsimple.publicapichooser.ui.api.list

import androidx.core.os.bundleOf
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ApisFragmentTest {

    lateinit var scenario: FragmentScenario<ApisFragment>


    @Before
    fun setUp() {
        val fragmentArgs = bundleOf(Pair("category_name", "IT"))
        scenario = launchFragmentInContainer(fragmentArgs)
    }

    @Test
    fun onFragment() {
        scenario.onFragment {
            assertNotNull(it)
            assertEquals("IT", it.category)
        }
    }
}