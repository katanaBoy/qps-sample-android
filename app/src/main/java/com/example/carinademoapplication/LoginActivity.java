package com.example.carinademoapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class LoginActivity extends AppCompatActivity implements  View.OnClickListener{

    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = (Button)findViewById(R.id.login_button);
        loginButton.setOnClickListener(this);
    }

    @Override
    public  void  onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                startActivity(new Intent(this, DescriptionActivity.class));
                break;
        }
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radio_male:
                if (checked)
                    break;
            case R.id.radio_female:
                if (checked)
                    break;
        }
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.checkbox:
                if (checked)
                loginButton.setEnabled(true);
            else
                loginButton.setEnabled(false);
        }
    }
}
