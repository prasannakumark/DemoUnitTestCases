package com.borqs.demounittest.model;

import android.content.SharedPreferences;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

import static com.borqs.demounittest.model.SharedPreferenceUtility.KEY_EMAIL;
import static com.borqs.demounittest.model.SharedPreferenceUtility.KEY_PASSWORD;
import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class SharedPreferenceUtilityTest {

    @InjectMocks
    SharedPreferenceUtility sharedPreferenceUtility;

    @Mock
    SharedPreferences mockSharedPreferences;

    @Mock
    SharedPreferences.Editor editorPositiveCase;
    @Mock
    SharedPreferences.Editor editorNegativeCase;
    @Mock
    User mockUser;

    @Test
    public void  shouldBeTrueWhenWriteEmailToPreferanceWithValidCommit() {
        initEditorObjWithPositiveCommit();
        assertTrue(sharedPreferenceUtility.writeEmailIdToPref("prasannakumar.p@gmail.com"));
    }

    @Test
    public void shouldBeFalseWhenWriteEmailToPreferanceWithInvalidCommit() {
        initEditorObjWithNegativeCommit();
        assertFalse(sharedPreferenceUtility.writeEmailIdToPref("prasannakumar.p@gmail.com"));
    }

    @Test
    public void  shouldBeTrueWhenWritePasswordToPreferanceWithValidCommit() {
        initEditorObjWithPositiveCommit();
        assertTrue(sharedPreferenceUtility.writePasswordToPref("123456"));
    }

    @Test
    public void shouldBeFalseWhenWritePasswordToPreferanceWithInvalidCommit() {
        initEditorObjWithNegativeCommit();
        assertFalse(sharedPreferenceUtility.writePasswordToPref("123456"));
    }

    @Test
    public void shouldBeTrueWhenWriteUserDataToPref() {
        initEditorObjWithPositiveCommit();
        Mockito.when(mockUser.getEmail()).thenReturn("Prasannakumar.p@gmail.com");
        Mockito.when(mockUser.getPassword()).thenReturn("123455");
        assertTrue(sharedPreferenceUtility.writeUserDataToPref(mockUser));
    }

    @Test
    public void shouldBeFailWhenWriteUserDataToPref() {
        initEditorObjWithNegativeCommit();
        Mockito.when(mockUser.getEmail()).thenReturn("Prasannakumar.p@gmail.com");
        Mockito.when(mockUser.getPassword()).thenReturn("123455");
        assertFalse(sharedPreferenceUtility.writeUserDataToPref(mockUser));
    }

    @Test
    public void shouldBeEqualEmailId() {
        Mockito.when(mockSharedPreferences.getString(KEY_EMAIL,null)).thenReturn("PrasannaKumar.p@gmail.com");
        assertEquals("PrasannaKumar.p@gmail.com", sharedPreferenceUtility.getStringKeyValue(KEY_EMAIL));
    }

    @Test
    public void shouldBeEqualPassword() {
        Mockito.when(mockSharedPreferences.getString(KEY_PASSWORD, null)).thenReturn("123456");
        assertEquals("123456", sharedPreferenceUtility.getStringKeyValue(KEY_PASSWORD));
    }

    @After
    public void tearDown() {
        sharedPreferenceUtility = null;
    }

    private void initEditorObjWithPositiveCommit() {
        Mockito.when(mockSharedPreferences.edit()).thenReturn(editorPositiveCase);
        Mockito.when(mockSharedPreferences.edit().commit()).thenReturn(true);
    }

    private void initEditorObjWithNegativeCommit() {
        Mockito.when(mockSharedPreferences.edit()).thenReturn(editorNegativeCase);
        Mockito.when(mockSharedPreferences.edit().commit()).thenReturn(false);
    }
}
