package com.borqs.demounittest.junittest;

public class Calculator {

    public int add(int firstValue,int secondValue) {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return (firstValue + secondValue);
    }

    public int sub(int firstValue,int secondValue) {
        return (firstValue - secondValue);
    }

    public int multiply(int firstValue, int secondValue) {
        return firstValue * secondValue;
    }

}
