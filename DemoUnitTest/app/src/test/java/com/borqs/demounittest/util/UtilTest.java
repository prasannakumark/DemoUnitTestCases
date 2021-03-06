package com.borqs.demounittest.util;

import android.text.TextUtils;
import android.util.Patterns;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(PowerMockRunner.class)
@PrepareForTest({TextUtils.class, Patterns.class})
public class UtilTest {

    @Before
    public void setUP() {
        PowerMockito.mockStatic(TextUtils.class);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionWhenEmailIdIsNull() {
        Util.isValidEmail(null);
    }

    @Test
    public void shouldBeFalseWhenEmailIsEmpty() {
        assertFalse(Util.isValidEmail(""));
    }

    @Test
    public void shouldBeFalseWhenEmailIdNotValid() {
        assertFalse(Util.isValidEmail("prasanna kumar"));
    }

    @Test
    public void shouldBeTrueWhenEmailIdValid() {
        assertTrue(Util.isValidEmail("PrasannaKumar.p@gmail.com"));
    }

    @Test(expected = NullPointerException.class)
    public void shouldThroeExceptionWhenPasswordIsNull() {
        Util.isValidPassWord(null);
    }

    @Test
    public void shouldBeFalseWhenPasswordIsEmpty() {
        assertFalse(Util.isValidPassWord(""));
    }

    @Test
    public void shouldBeFalseWhenPasswordLessThanFiveChars() {
        assertFalse(Util.isValidPassWord("1234"));
    }

    @Test
    public void shouldBeTrueWhenPasswordIsMoreThanFiveChars() {
        assertTrue(Util.isValidPassWord("123456"));
    }


    @Test
    public void shouldBeFalseWhenEmailIdValidAndPasswordWrong() {
        assertFalse(Util.isValidEmailAndPassword("PrasannaKumar.p@gmail.com",""));
    }

    @Test
    public void shouldBeFalseWhenPasswordValidAndEmailIdWrong() {
        assertFalse(Util.isValidEmailAndPassword("","123456"));
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowAnExceptionWhenEmailIdOrPasswordNull() {
        Util.isValidEmailAndPassword(null,"123456");
        Util.isValidEmailAndPassword("Prasannakumar.p@gmail.com",null);
    }

    @Test
    public void shouldBeThruWhenValidEmailIdAndPassword() {
        assertTrue(Util.isValidEmailAndPassword("prasannakumar.p@gmail.com","123456"));
    }

}