package com.androiduitesting.movie

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.androiduitesting.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MovieNavigationTest {

    @Test
    fun testMovieFragmentNavigation() {

        //launch activity
        val activityScenario = ActivityScenario.launch(MovieActivity::class.java)

        //navigate to directors fragment
        onView(withId(R.id.movie_directiors)).perform(click())

        //verify directors view is displayed
        onView(withId(R.id.fragment_movie_director_parent)).check(matches(isDisplayed()))

        //navigate back to movie details page
        pressBack()

        //verify movie details page is loaded
        onView(withId(R.id.fragment_movie_detail_parent)).check(matches(isDisplayed()))

        //navigate to star actors fragment
        onView(withId(R.id.movie_star_actors)).perform(click())

        //verify star actors page is loaded
        onView(withId(R.id.fragment_movie_star_actors_parent)).check(matches(isDisplayed()))
    }
}