package com.borqs.demounittest.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.borqs.demounittest.model.DataModelManager;
import com.borqs.demounittest.model.User;
import com.borqs.demounittest.util.Util;

public class LoginViewModel extends BaseObservable {

    private User mUser;

    private String successMessage = "Login was successful";
    private String errorMessage = "Email or Password not valid";

    @Bindable
    public String toastMessage = null;

    private DataModelManager mDataModelManager;
    private CallBack mCallBack;

    public LoginViewModel(@NonNull final DataModelManager dataModelManager, User user) {
        mDataModelManager = dataModelManager;
        mUser = user;
    }

    public String getToastMessage() {
        return toastMessage;
    }

    @VisibleForTesting
    public void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(com.borqs.demounittest.BR.toastMessage);
    }


    public void afterEmailTextChanged(CharSequence s) {
        mUser.setEmail(s.toString());
    }

    public void afterPasswordTextChanged(CharSequence s) {
        mUser.setPassword(s.toString());
    }

    @VisibleForTesting
    public void onLoginClicked() {
        try {
            if (Util.isValidEmailAndPassword(mUser.getEmail(), mUser.getPassword())) {
                setToastMessage(successMessage);
                boolean isCommited = mDataModelManager.writeUserDataToPref(mUser);
                if(isCommited) {
                    if(this.mCallBack != null) {
                        this.mCallBack.startHomePageActivtity();
                    } else {
                        throw new IllegalStateException("Callbacks must not be null");
                    }
                }
            } else
                setToastMessage(errorMessage);
        }catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
            setToastMessage(errorMessage);
        }
    }

    public interface CallBack {
        void startHomePageActivtity();
    }

    public void setCallBack(CallBack callBack) {
        this.mCallBack = callBack;
    }
}
