package com.borqs.demounittest.util;

import android.support.v4.util.PatternsCompat;
import android.text.TextUtils;
import android.util.Patterns;

public class Util {


    /**
     * To check email Is valid or not
     * @param email
     * @return
     */
    public static boolean isValidEmail(String email) throws NullPointerException{
        if(email == null) {
            throw new NullPointerException("Email Id must not be null");
        }

        return !TextUtils.isEmpty(email) && PatternsCompat.EMAIL_ADDRESS.matcher(email).matches();
    }

    /**
     * To check password valid or not
     * @param password
     * @return
     */
    public static boolean isValidPassWord(String password) throws NullPointerException{
        if(password == null) {
            throw new NullPointerException("Password must not be null");
        }

        return !TextUtils.isEmpty(password) && password.length() > 5;
    }

    public static boolean isValidEmailAndPassword(String email, String password) throws NullPointerException{
        return isValidEmail(email) && isValidPassWord(password);
    }

}
