package com.borqs.demounittest.junittest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import junitparams.mappers.CsvWithHeaderMapper;


@RunWith(JUnitParamsRunner.class)
public class CalculatorTest {

    private Calculator calculator;

    private Collection<Object[]> multiply() {
        Object[][] data = new Object[][] {{ 1 , 2, 2}, { 5, 3, 15 }, { 121, 4, 484 }};
        return Arrays.asList(data);
    }

    private Collection<Object[]> additions() {
        Object[][] data = new Object[][] {{ 1 , 1, 2}, { 5, 3, 8 }, { 121, 4, 125}};
        return Arrays.asList(data);
    }

    @Test
    @FileParameters("src/test/resouces/test.csv")
    public void loadParamsFromFileWithIdentityMapper(int m1, int m2, int result) {
        assertEquals(result, calculator.add(m1,m2));
    }


    @Before
    public void setUP() {
        System.out.println("setUP");
        calculator = new Calculator();
    }

    @Test(timeout = 100)
    @Parameters(method = "additions")
    public void addTest(int m1,int m2, int result) {
        assertEquals(result, calculator.add(m1,m2));
    }

    @Test
    @Parameters(method = "multiply")
    public void multuplyTest(int m4, int m5, int m6) {
        assertEquals(m6,calculator.multiply(m4,m5));
    }

    @After
    public void tearDown() {
        calculator = null;
        System.out.println("tearDown");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("tearDownClass");
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("setUpClass");
    }
}