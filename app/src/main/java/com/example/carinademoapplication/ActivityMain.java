package com.example.carinademoapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.next_button).setOnClickListener(v -> {
            startActivity(new Intent(ActivityMain.this, ActivityLoginForm.class));
            finish();
        });
    }
}
