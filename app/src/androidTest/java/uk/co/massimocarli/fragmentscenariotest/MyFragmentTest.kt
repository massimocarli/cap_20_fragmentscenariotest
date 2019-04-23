package uk.co.massimocarli.fragmentscenariotest

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MyFragmentTest {

  @Test
  fun pushButton_toastDisplayMessage() {
    val scenario = launchFragmentInContainer<MyFragment>()
    // We click the Button
    Espresso.onView(ViewMatchers.withId(R.id.showToastButton))
      .perform(ViewActions.click())
    // We check the Toast
    Espresso.onView(ViewMatchers.withText(R.string.toast_message))
      .inRoot(ToastMatcher())
      .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
  }

  @Test
  fun callShowToast_toastDisplayMessage() {
    val scenario =
      launchFragmentInContainer<MyFragment>()
    scenario.onFragment {
      it.showToast()
    }
    // We check the Toast
    Espresso.onView(ViewMatchers.withText(R.string.toast_message))
      .inRoot(ToastMatcher())
      .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
  }

}
