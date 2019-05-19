package com.borqs.demounittest.model;

public class DataModelManager {

    private final SharedPreferenceUtility mSharedPreferenceUtility;

    public DataModelManager(SharedPreferenceUtility sharedPreferenceUtility) {
        this.mSharedPreferenceUtility = sharedPreferenceUtility;
    }

    public boolean writeUserDataToPref(User user) {
        return mSharedPreferenceUtility.writeUserDataToPref(user);
    }

    public boolean isUserLoggedIn() {
        return mSharedPreferenceUtility.isUserLoggedin();
    }

}
