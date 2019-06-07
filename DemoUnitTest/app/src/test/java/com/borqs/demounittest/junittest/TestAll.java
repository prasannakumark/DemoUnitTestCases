package com.borqs.demounittest.junittest;

import android.telecom.TelecomManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({CalculatorTest.class,MessagePrintTest.class})
public class TestAll {

    @Before
    public void setUp() {
        System.out.println("------------------------");
        Result result = JUnitCore.runClasses(CalculatorTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }

    @Test
    public void assetTrueTest() {
    }
}
