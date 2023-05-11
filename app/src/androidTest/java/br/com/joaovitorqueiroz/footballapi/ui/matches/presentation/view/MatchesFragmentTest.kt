package br.com.joaovitorqueiroz.footballapi.ui.matches.presentation.view

import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.joaovitorqueiroz.footballapi.R
import br.com.joaovitorqueiroz.footballapi.hiltExtension.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class MatchesFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun navigation_match_screen() {
//        GIVEN
        val navHostController =
            TestNavHostController(ApplicationProvider.getApplicationContext())

        launchFragmentInHiltContainer<MatchesFragment> {
            navHostController.setGraph(R.navigation.main_graph)
            navHostController.setCurrentDestination(R.id.matchesFragment)
            Navigation.setViewNavController(this.requireView(), navHostController)
        }
//      WHEN
        onView(
            withId(R.id.item_match),
        ).perform(ViewActions.click())
//      THEN
        Assert.assertEquals(
            navHostController.currentDestination?.id,
            R.id.matchFragment,
        )
    }
}
