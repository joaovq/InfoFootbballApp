package br.com.joaovitorqueiroz.footballapi.ui.home.view

import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.joaovitorqueiroz.footballapi.R
import br.com.joaovitorqueiroz.footballapi.hiltExtension.launchFragmentInHiltContainer
import br.com.joaovitorqueiroz.footballapi.ui.home.presentation.view.OnboardingPresentationFragment
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
internal class OnboardingPresentationFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun testNavigationToHomeFragment() {
//        create
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
//          while
        launchFragmentInHiltContainer<OnboardingPresentationFragment> {
            navController.setGraph(R.navigation.main_graph)
            navController.setCurrentDestination(R.id.homeFragment)
            Navigation.setViewNavController(this.requireView(), navController)
        }
        onView(withId(R.id.fab_next_button)).perform(ViewActions.click())
        onView(withId(R.id.fab_next_button)).perform(ViewActions.click())
        onView(withId(R.id.btn_get_started))
            .perform(ViewActions.closeSoftKeyboard())
            .perform(ViewActions.click())
//        then
        Assert.assertEquals(
            navController.currentDestination?.id,
            R.id.homeFragment,
        )
    }
}
