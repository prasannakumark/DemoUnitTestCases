package com.borqs.demounittest.junittest;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilTest {

    @Test
    public void squareTest() {
        assertEquals(25, Util.square(5));
    }

    @Test
    public void charCountTest() {
        assertEquals(2,Util.charCount("Madam", 'm'));
    }

}