package com.borqs.demounittest.view;

import android.support.test.espresso.action.ViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.borqs.demounittest.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class CalculatorActivityTest {

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule<>(CalculatorActivity.class);

    @Test
    public void shouldShowErrorWhenInputsAreEmpty() {
        onView(withId(R.id.btn_addition)).perform(ViewActions.click());
        onView(withId(R.id.txt_displaytext)).check(matches(withText(CalculatorActivity.ERROR_FIRST_OR_SECOND_VALUE_NOT_EMPTY)));
    }

    @Test
    public void shouldDoAddtionWithValidNumbers() {
        onView(withId(R.id.edt_first_value)).perform(typeText("30"));
        onView(withId(R.id.edt_second_value)).perform(typeText("30"));

        onView(withId(R.id.btn_addition)).perform(click());

        onView(withId(R.id.txt_displaytext)).check(matches(withText("60")));
    }

    @Test
    public void shouldDoSubtracionWithValideNumbers() {
        onView(withId(R.id.edt_first_value)).perform(typeText("30"));
        onView(withId(R.id.edt_second_value)).perform(typeText("30"));

        onView(withId(R.id.btn_subtraction)).perform(click());
        onView(withId(R.id.txt_displaytext)).check(matches(withText("0")));
    }

}