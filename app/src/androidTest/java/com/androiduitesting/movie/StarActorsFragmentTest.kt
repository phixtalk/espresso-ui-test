package com.androiduitesting.movie

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.androiduitesting.R
import com.androiduitesting.factory.MovieFragmentFactory
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class StarActorsFragmentTest{

    @Test
    fun test_isStarActorsListVisible() {

        //SETUP
        val actors = arrayListOf("Dwayne Johnson", "Seann William Scott", "Rosario Dawson", "Christopher Walken")
        val fragmentFactory = MovieFragmentFactory()
        val bundle = Bundle()
        bundle.putStringArrayList("args_actors", actors)

        //next we launch the fragment in isolation for testing
        val scenario = launchFragmentInContainer<StarActorsFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )

        //VERIFY
        Espresso.onView(ViewMatchers.withId(R.id.star_actors_text)).check(
            ViewAssertions.matches(
                ViewMatchers.withText(
                    StarActorsFragment.stringBuilderForStarActors(actors)
                )
            )
        )

    }

}