package com.borqs.demounittest.viewmodel;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Patterns;

import com.borqs.demounittest.model.DataModelManager;
import com.borqs.demounittest.model.SharedPreferenceUtility;
import com.borqs.demounittest.model.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest({TextUtils.class, Patterns.class})
public class LoginViewModelTest {

    @InjectMocks
    LoginViewModel subject;

    @Mock
    User mockUser;

    @Mock
    DataModelManager mocDataModelManager;

    @Mock
    SharedPreferenceUtility mockSharedPreferenceUtility;

    @Mock
    SharedPreferences mockSharedPreferences;

    @Mock
    SharedPreferences.Editor mockEditor;

    @Mock
    LoginViewModel.CallBack mockCallBack;

    @Before
    public void setUp() throws Exception {
        PowerMockito.mockStatic(TextUtils.class);
    }

    @Test
    public void shouldShowErrorMessageWhenEmailIdOrPasswordWrong() {
        Mockito.when(mockUser.getEmail()).thenReturn("PrasannaKumar.p");
        Mockito.when(mockUser.getPassword()).thenReturn("fhjsdfhjsd");
        Mockito.when(mocDataModelManager.writeUserDataToPref(mockUser)).thenReturn(true);

        subject.onLoginClicked();
        assertEquals("Email or Password not valid",subject.toastMessage);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowAnExceptionWhenCallBackIsNull() {
        Mockito.when(mockUser.getEmail()).thenReturn("PrasannaKumar.p@gmail.com");
        Mockito.when(mockUser.getPassword()).thenReturn("fhjsdfhjsd");
        Mockito.when(mockSharedPreferences.edit()).thenReturn(mockEditor);
        Mockito.when(mockEditor.commit()).thenReturn(true);
        Mockito.when(mockSharedPreferenceUtility.writeUserDataToPref(mockUser)).thenReturn(true);
        Mockito.when(mocDataModelManager.writeUserDataToPref(mockUser)).thenReturn(true);

        subject.onLoginClicked();
    }

    @Test
    public void shouldShowSuccessMessageWhenEmailIdOrPasswordValid() {
        Mockito.when(mockUser.getEmail()).thenReturn("PrasannaKumar.p@gmail.com");
        Mockito.when(mockUser.getPassword()).thenReturn("fhjsdfhjsd");
        subject.setCallBack(mockCallBack);
        subject.onLoginClicked();
        assertEquals("Login was successful", subject.toastMessage);
    }

    @After
    public void tearDown() throws Exception {
        subject = null;
    }
}