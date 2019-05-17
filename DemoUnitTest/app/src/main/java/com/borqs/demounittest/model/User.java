package com.borqs.demounittest.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;

public class User {
    private String email;
    private String password;

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }
}
