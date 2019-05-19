package com.borqs.demounittest.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.borqs.demounittest.R;
import com.borqs.demounittest.model.DataModelManager;
import com.borqs.demounittest.model.SharedPreferenceUtility;
import com.borqs.demounittest.viewmodel.HomePageViewModel;

public class HomePageActivity extends AppCompatActivity implements HomePageViewModel.CallBack {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_home_page);
        HomePageViewModel homePageViewModel =
                new HomePageViewModel(
                        new DataModelManager(
                                new SharedPreferenceUtility(
                                        this.getSharedPreferences(
                                                SharedPreferenceUtility.USER_LOGGED_IN,MODE_PRIVATE))));

        homePageViewModel.setCallBacks(this);
        homePageViewModel.isUserLogedIn();
    }

    @Override
    public void startLoginActivity() {
        startActivity(new Intent(this, LoginPageActivity.class));
    }
}
