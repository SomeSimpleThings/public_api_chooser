package com.somethingsimple.publicapichooser.details

import androidx.core.os.bundleOf
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.somethingsimple.publicapichooser.R
import com.somethingsimple.publicapichooser.data.vo.ApiEntry
import com.somethingsimple.publicapichooser.ui.api.details.ApiDetailsFragment
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ApiDetailsFragmentTest {

    lateinit var scenario: FragmentScenario<ApiDetailsFragment>

    @Before
    fun setUp() {
        val fragmentArgs = bundleOf("api_id" to 18L)
        scenario = launchFragmentInContainer(fragmentArgs)
    }

    @Test
    fun onFragment() {
        scenario.onFragment {
            assertNotNull(it)
            assertEquals(18L, it.apiId)
        }
    }

    @Test
    fun textFieldsMatches() {
        val apiEntry = ApiEntry(
            18L,
            "Some awesome api",
            "",
            "Programming",
            "no",
            "Description of awesome api",
            true,
            "https://alexwohlbruck.github.io/cat-facts/",
        )
        scenario.onFragment {
            it.showDetails(apiEntry)
            val matcher = withText(apiEntry.category)
            onView(withId(R.id.api_category_l)).perform(click())
            onView(withId(R.id.api_category_l)).check(matches(matcher))
            onView(withId(R.id.api_auth)).check(matches(withText(apiEntry.auth)))
            onView(withId(R.id.api_description)).check(matches(withText(apiEntry.description)))
            onView(withId(R.id.api_name)).check(matches(withText(apiEntry.api)))
            onView(withId(R.id.api_url)).check(matches(withText(apiEntry.link)))
        }
    }

    @After
    fun tearDown() {
    }
}
