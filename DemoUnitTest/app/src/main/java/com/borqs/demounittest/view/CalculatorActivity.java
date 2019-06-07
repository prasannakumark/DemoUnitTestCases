package com.borqs.demounittest.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.borqs.demounittest.R;
import com.borqs.demounittest.junittest.Calculator;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String ERROR_FIRST_OR_SECOND_VALUE_NOT_EMPTY = "FirstOrSecondValuesMustNotBeEmpty";

    private EditText mFirstValue, mSecondValue;
    private Button mBtnAddition, mBtnSubtraction;

    private TextView mTxtDisplayValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        init();
    }

    private void init() {
        mFirstValue = findViewById(R.id.edt_first_value);
        mSecondValue = findViewById(R.id.edt_second_value);
        mBtnAddition = findViewById(R.id.btn_addition);
        mBtnSubtraction = findViewById(R.id.btn_subtraction);

        mTxtDisplayValue = findViewById(R.id.txt_displaytext);

        mBtnSubtraction.setOnClickListener(this);
        mBtnAddition.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String firstValue = mFirstValue.getText().toString();
        String secondValue = mSecondValue.getText().toString();
        switch (v.getId()) {
            case R.id.btn_addition:

                if(firstValue.length() == 0 || secondValue.length() == 0) {
                    mTxtDisplayValue.setText(ERROR_FIRST_OR_SECOND_VALUE_NOT_EMPTY);
                } else {
                    Calculator calculator = new Calculator();
                    int result = calculator.add(Integer.valueOf(firstValue), Integer.valueOf(secondValue));
                    mTxtDisplayValue.setText(String.valueOf(result));
                }
                break;
            case R.id.btn_subtraction:
                if(firstValue.length() == 0 || secondValue.length() == 0) {
                    mTxtDisplayValue.setText(ERROR_FIRST_OR_SECOND_VALUE_NOT_EMPTY);
                } else {
                    Calculator calculator = new Calculator();
                    int result = calculator.sub(Integer.valueOf(firstValue), Integer.valueOf(secondValue));
                    mTxtDisplayValue.setText(String.valueOf(result));
                }
                break;
        }

    }
}
