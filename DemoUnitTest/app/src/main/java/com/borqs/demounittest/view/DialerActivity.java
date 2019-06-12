package com.borqs.demounittest.view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.borqs.demounittest.R;

public class DialerActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_CODE_PICK = 16;

    private EditText mEditEnterNumber;
    private Button mBtnCallNumber;
    private Button mBtnPickContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialer);
        init();
    }

    private void init() {
        mEditEnterNumber = findViewById(R.id.edit_text_caller_number);
        mBtnCallNumber = findViewById(R.id.button_call_number);
        mBtnPickContact = findViewById(R.id.button_pick_contact);
        mBtnCallNumber.setOnClickListener(this);
        mBtnPickContact.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_call_number:
                boolean hasCallPhonePermission = ContextCompat.checkSelfPermission(this,
                        Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED;

                if (hasCallPhonePermission) {
                    if(mEditEnterNumber.getText().length() == 0) {
                        Toast.makeText(this, "Number must not be empty", Toast.LENGTH_SHORT);
                    } else {
                        startActivity(createCallIntentFromNumber());
                    }
                } else
                    Toast.makeText(this, R.string.warning_call_phone_permission, Toast.LENGTH_SHORT);
                break;
            case R.id.button_pick_contact:
                    final Intent pickContactIntent = new Intent(this, ContactsActivity.class);
                    startActivityForResult(pickContactIntent, REQUEST_CODE_PICK);
                break;
        }
    }

    private Intent createCallIntentFromNumber() {
        final Intent intentToCall = new Intent(Intent.ACTION_CALL);
        String number = mEditEnterNumber.getText().toString();
        intentToCall.setData(Uri.parse("tel:" + number));
        return intentToCall;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK) {
            if (resultCode == RESULT_OK) {
                mEditEnterNumber.setText(data.getExtras()
                        .getString(ContactsActivity.KEY_PHONE_NUMBER));
            }
        }
    }
}
