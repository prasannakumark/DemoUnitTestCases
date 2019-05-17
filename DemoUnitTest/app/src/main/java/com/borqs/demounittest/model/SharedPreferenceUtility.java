package com.borqs.demounittest.model;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

public class SharedPreferenceUtility {

    public static final String USER_LOGGED_IN = "userloggedin";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";

    private SharedPreferences sharedPreferences;

    public SharedPreferenceUtility(@NonNull SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public boolean writeEmailIdToPref(String email) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_EMAIL, email);
        return editor.commit();
    }

    public boolean writePasswordToPref(String password) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_PASSWORD, password);
        return editor.commit();
    }

    public boolean writeUserDataToPref(User user) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_EMAIL, user.getEmail());
        editor.putString(KEY_PASSWORD, user.getPassword());
        return editor.commit();
    }

    public Object getStringKeyValue(String key) {
        return sharedPreferences.getString(key, null);
    }
}
