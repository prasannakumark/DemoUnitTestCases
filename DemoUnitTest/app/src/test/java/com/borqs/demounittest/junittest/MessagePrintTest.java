package com.borqs.demounittest.junittest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessagePrintTest {

    private final static String MESSAGE = "Junit testing";

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getMessage() {
        MessagePrint messagePrint = new MessagePrint(MESSAGE);

        assertEquals("Messages are same",MESSAGE, messagePrint.getMessage());
    }
}