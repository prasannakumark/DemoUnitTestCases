package com.borqs.demounittest.view;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.borqs.demounittest.R;
import com.borqs.demounittest.databinding.ActivityMainBinding;
import com.borqs.demounittest.model.DataModelManager;
import com.borqs.demounittest.model.SharedPreferenceUtility;
import com.borqs.demounittest.model.User;
import com.borqs.demounittest.viewmodel.LoginViewModel;

public class LoginPageActivity extends AppCompatActivity implements LoginViewModel.CallBack{

    private LoginViewModel mLoginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mLoginViewModel =
                new LoginViewModel(
                new DataModelManager(
                new SharedPreferenceUtility(
                this.getSharedPreferences(SharedPreferenceUtility.USER_LOGGED_IN,MODE_PRIVATE))),new User());
        activityMainBinding.setViewModel(mLoginViewModel);
        activityMainBinding.executePendingBindings();

        mLoginViewModel.setCallBack(this);
    }

    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message) {
        if (message != null)
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startHomePageActivtity() {
        startActivity(new Intent(this, HomePageActivity.class));
    }
}
