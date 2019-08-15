package com.example.populararticles.ui

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.contrib.DrawerMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.example.populararticles.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation


@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest{

    @get:Rule
    val mMainActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun onViewLoadedShowPopularArticlesFragment() {
        onView(withId(R.id.main_fragment)).check(matches(isDisplayed()))
//        onView(withId(R.id.toolbar)).check(matches(hasDescendant(withText("Article Articles"))))
    }

    @Test
    fun navigationViewNavigatesMeToHomeOnClick() {
        onView(withId(R.id.drawerLayout)).perform(DrawerActions.open())

        onView(withText(R.string.home)).perform(click())
        onView(withId(R.id.toolbar)).check(matches(hasDescendant(withText("Home"))))
    }

    @Test
    fun navigationViewNavigatesMeToTrendingOnClick() {

        onView(withId(R.id.drawerLayout)).perform(DrawerActions.open())

        onView(withText(R.string.home)).perform(click())
        onView(withId(R.id.toolbar)).check(matches(hasDescendant(withText("Home"))))
        onView(withId(R.id.drawerLayout)).perform(DrawerActions.close())

        Thread.sleep(1000)

        onView(withId(R.id.drawerLayout)).perform(DrawerActions.open())
        onView(withText(R.string.popular)).perform(click())
        onView(withId(R.id.toolbar)).check(matches(hasDescendant(withText("Article Articles"))))

    }

    @Test
    fun drawerClosesWhenBackButtonIsPressed() {
        onView(withId(R.id.drawerLayout)).perform(DrawerActions.open())
        Espresso.pressBack()
        onView(withId(R.id.drawerLayout)).check(matches(DrawerMatchers.isClosed()))
    }


    @Test
    fun testClickAboutMenuItem() {
        openActionBarOverflowOrOptionsMenu(getInstrumentation().targetContext)
        onView(withText("About")).perform(click())
        onView(withId(R.id.toolbar)).check(matches(hasDescendant(withText("About"))))

    }

}