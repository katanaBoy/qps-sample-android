package com.example.carinademoapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ActivitySplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        findViewById(R.id.next_button).setOnClickListener(v -> {
            startActivity(new Intent(ActivitySplash.this, ActivityLoginForm.class));
            finish();
        });
    }
}
