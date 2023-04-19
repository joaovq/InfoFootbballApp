package br.com.joaovitorqueiroz.footballapi.ui.home.view

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.joaovitorqueiroz.footballapi.R
import br.com.joaovitorqueiroz.footballapi.ui.home.presentation.view.OnboardingPresentationFragment
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class OnboardingPresentationFragmentTest {
    @Test
    fun testNavigationToHomeFragment() {
//        create
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())

        val onboardinScenario = launchFragmentInContainer<OnboardingPresentationFragment>(
            themeResId = R.style.Theme_FootballApi,
        )
        onboardinScenario.onFragment { fragment ->
            navController.setGraph(R.navigation.main_graph)
            Navigation.setViewNavController(fragment.requireView(), navController)
        }

        onView(withId(R.id.fab_next_button)).perform(ViewActions.click())
        onView(withId(R.id.fab_next_button)).perform(ViewActions.click())
        onView(withId(R.id.btn_get_started))
            .perform(ViewActions.closeSoftKeyboard())
            .perform(ViewActions.click())
        Assert.assertEquals(
            navController.currentDestination?.id,
            R.id.homeFragment,
        )
    }
}
