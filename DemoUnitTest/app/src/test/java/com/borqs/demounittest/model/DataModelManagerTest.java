package com.borqs.demounittest.model;

import android.content.SharedPreferences;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DataModelManagerTest {

    @InjectMocks
    DataModelManager subject;
    @Mock
    SharedPreferenceUtility sharedPreferenceUtility;
    @Mock
    User user;
    @Mock
    SharedPreferences sharedPreferences;
    @Mock
    SharedPreferences.Editor editor;


    @Before
    public void setUp() {}

    @Test
    public void shouldWriteUserDataToPrefInUtility() {
        subject.writeUserDataToPref(user);
        Mockito.verify(sharedPreferenceUtility,Mockito.atLeast(1)).writeUserDataToPref(user);
    }

    @After
    public void tearDown() throws Exception {
        subject = null;
    }
}