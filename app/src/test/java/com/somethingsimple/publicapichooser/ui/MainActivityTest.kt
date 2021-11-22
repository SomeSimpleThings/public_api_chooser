package com.somethingsimple.publicapichooser.ui

import android.os.Build
import android.widget.FrameLayout
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import com.somethingsimple.publicapichooser.R
import junit.framework.Assert.assertNotNull
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.R])
class MainActivityTest {

    lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun onActivity() {
        scenario.onActivity { assertNotNull(it) }
    }

    @Test
    fun activity_IsResumed() {
        assertEquals(Lifecycle.State.RESUMED, scenario.state)
    }

    @After
    fun close() {
        scenario.close()
    }

}