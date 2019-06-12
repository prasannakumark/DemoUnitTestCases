package com.borqs.demounittest.view;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.net.Uri;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.matcher.ComponentNameMatchers;
import android.support.test.espresso.intent.matcher.IntentMatchers;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;

import com.borqs.demounittest.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class DialerActivityTest {

    public static final String VALID_NUMBER = "896-745-231";
    public static final Uri INTENT_VALIDE_NUMBER = Uri.parse("tel:" +VALID_NUMBER);

    @Rule
    public IntentsTestRule intentsTestRule = new IntentsTestRule(DialerActivity.class);
    @Rule
    public GrantPermissionRule grantPermissionRule = GrantPermissionRule.grant("android.permission.CALL_PHONE");

    @Before
    public void stubAllExternalIntents() {
        //By default espresso will dose not stub any intent.Stubbing needs to be setup before
        //every test run. In this case all external Intents will be blocked.
        intending(not(IntentMatchers.isInternal())).respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK, null));
    }

    @Test
    public void typeNumber_validInput_initiateCall() {
        onView(withId(R.id.edit_text_caller_number)).perform(ViewActions.typeText(VALID_NUMBER));
        onView(withId(R.id.button_call_number)).perform(click());

        Intents.intended(allOf(IntentMatchers.hasAction(Intent.ACTION_CALL),
                IntentMatchers.hasData(INTENT_VALIDE_NUMBER)));
    }

    @Test
    public void typeNumber_validInput_initCall_truth() {
        Espresso.onView(withId(R.id.edit_text_caller_number)).perform(ViewActions.typeText(VALID_NUMBER));
        Espresso.onView(withId(R.id.button_call_number)).perform(ViewActions.click());
    }

    @Test
    public void pick_number_from_contacts() {
        // Stub all Intents to ContactsActivity to return VALID_PHONE_NUMBER. Note that the Activity
        // is never launched and result is stubbed.
        intending(IntentMatchers.hasComponent(ComponentNameMatchers.hasShortClassName(".ContactsActivity")))
                .respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK,
                        ContactsActivity.createResultData(VALID_NUMBER)));

        // Click the pick contact button.
        onView(withId(R.id.button_pick_contact)).perform(click());

        // Check that the number is displayed in the UI.
        onView(withId(R.id.edit_text_caller_number))
                .check(matches(ViewMatchers.withText(VALID_NUMBER)));
    }
}