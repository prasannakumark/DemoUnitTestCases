package com.borqs.demounittest.viewmodel;

import android.databinding.BaseObservable;
import android.support.annotation.NonNull;

import com.borqs.demounittest.model.DataModelManager;

public class HomePageViewModel extends BaseObservable {

    private final DataModelManager mDataModelManager;

    public HomePageViewModel(@NonNull final DataModelManager dataModelManager) {
        mDataModelManager = dataModelManager;
    }
}
