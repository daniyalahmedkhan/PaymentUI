package com.daniyal.payment.ui;

import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.daniyal.payment.R;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4ClassRunner.class)
public class BaseActivityTest {

    /* Check on App Open Main Activity Should Open as Home Page with Toolbar */
    @Rule
    public ActivityScenarioRule<BaseActivity> activityActivityScenarioRule = new ActivityScenarioRule<BaseActivity>(BaseActivity.class);

    /* Check On Start Shimmer Should Show */
    @Test
    public void checkHomeLoadingShimmer_IsDisplayed() {
        Espresso.onView(withId(R.id.shimmer_view_container)).check(matches(isDisplayed()));
    }

    /* Check Once the Api Fetched Data Shimmer Should Hide */
    @Test
    public void checkHomeLoadingShimmer_IsGone() {

        Espresso.onView(isRoot()).perform(waitFor(10000));
        Espresso.onView(withId(R.id.shimmer_view_container)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
    }

    /* Check RecyclerView is Attached to the View */
    @Test
    public void checkRecyclerView_isAttached() {

        Espresso.onView(isRoot()).perform(waitFor(10000));
        Espresso.onView(withId(R.id.rv_paymentoption)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    /* Check RecyclerView On Item Click Listener Open the Detail Fragment */
    @Test
    public void animationOnItemClick() {

        Espresso.onView(isRoot()).perform(waitFor(10000));

        Espresso.onView(withId(R.id.rv_paymentoption)).perform(RecyclerViewActions.actionOnItemAtPosition(0, new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return null;
            }

            @Override
            public String getDescription() {
                return null;
            }

            @Override
            public void perform(UiController uiController, View view) {
                View v = view.findViewById(R.id.cv_item);
                v.performClick();

                // Espresso.onView(withId(v.getId())).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));

            }
        }));

        // Espresso.onView(withId(v.getId())).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));

    }




    /* Helping Func to Add Delay for Api Response*/

    /**
     * Perform action of waiting for a specific time.
     */
    public static ViewAction waitFor(final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "Wait for " + millis + " milliseconds.";
            }

            @Override
            public void perform(UiController uiController, View view) {
                uiController.loopMainThreadForAtLeast(millis);
            }

        };
    }


}