package com.borqs.demounittest.view;

import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.borqs.demounittest.R;
import com.borqs.demounittest.view.adapter.RecyclerViewTestAdapter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.Matchers.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RecyclerViewActivityTest {

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(RecyclerViewActivity.class);

    @Test
    public void shouldNotShow299Movie() {
        Espresso.onView(ViewMatchers.withText("MovieName 299")).check(ViewAssertions.doesNotExist());
    }

    @Test
    public void scrollAndCheckItemShouldExit() {
        Espresso.onView(ViewMatchers.withId(R.id.recycler_view)).perform(RecyclerViewActions.
                <RecyclerViewTestAdapter.MyViewHolder>scrollToPosition(299));
        Espresso.onView(ViewMatchers.withText("MovieName 299")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

}