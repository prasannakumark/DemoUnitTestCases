package com.borqs.demounittest.viewmodel;

import android.databinding.BaseObservable;
import android.support.annotation.NonNull;

import com.borqs.demounittest.model.DataModelManager;

public class HomePageViewModel extends BaseObservable {

    private final DataModelManager mDataModelManager;

    private CallBack mCallBacks;

    public interface CallBack {
        public void startLoginActivity();
    }

    public HomePageViewModel(@NonNull final DataModelManager dataModelManager) {
        mDataModelManager = dataModelManager;
    }

    public void setCallBacks(CallBack callBacks) {
        this.mCallBacks = callBacks;
    }

    public void isUserLogedIn() {
        boolean isUserLoggedIn = mDataModelManager.isUserLoggedIn();
        if(isUserLoggedIn) {
            userLoggedInSuccessFully("User login success");
            System.out.println("User logged in");
        } else {
            if(mCallBacks == null) {
                throw new IllegalStateException("Callbacks must not be null");
            } else {
                mCallBacks.startLoginActivity();
            }
        }
    }

    public void userLoggedInSuccessFully(CharSequence s) {
        System.out.println("User logged in");
    }


}
