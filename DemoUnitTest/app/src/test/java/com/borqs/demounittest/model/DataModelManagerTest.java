package com.borqs.demounittest.model;

import android.content.SharedPreferences;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class DataModelManagerTest {

    @InjectMocks
    DataModelManager subject;

    @Mock
    SharedPreferenceUtility sharedPreferenceUtility;

    @Before
    public void setUp() {}

    @After
    public void tearDown() throws Exception {
        subject = null;
    }
}