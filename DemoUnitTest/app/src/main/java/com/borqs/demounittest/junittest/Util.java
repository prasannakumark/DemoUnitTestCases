package com.borqs.demounittest.junittest;

public class Util {

    public static int square(int a) {
        return a*a;
    }

    public static int charCount(String str, Character ch) {
        int count = 0;
        for(int i = 0; i<str.length(); i++) {
            str = str.toLowerCase();
            if(str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }
}
