package com.example.carinademoapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;

public class ActivityLoginForm extends AppCompatActivity {

    private Button loginButton;
    private Switch privacySwitch;
    private RadioGroup genderRadioGroup;
    private EditText name, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityLoginForm.this, ActivityDescription.class));
            }
        });

        privacySwitch = findViewById(R.id.checkbox);
        privacySwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkIsNeedToEnableLoginButton();
            }
        });

        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        genderRadioGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkIsNeedToEnableLoginButton();
            }
        });

        name = findViewById(R.id.name);
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkIsNeedToEnableLoginButton();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        password = findViewById(R.id.password);
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkIsNeedToEnableLoginButton();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void checkIsNeedToEnableLoginButton() {
        boolean isNeedToEnableButton;

        isNeedToEnableButton = privacySwitch.isChecked();
        isNeedToEnableButton = isNeedToEnableButton && genderRadioGroup.getCheckedRadioButtonId() != -1;
        isNeedToEnableButton = isNeedToEnableButton && !TextUtils.isEmpty(name.getText());
        isNeedToEnableButton = isNeedToEnableButton && !TextUtils.isEmpty(password.getText());

        if (isNeedToEnableButton) {
            loginButton.setEnabled(true);
        } else {
            loginButton.setEnabled(false);
        }
    }
}
