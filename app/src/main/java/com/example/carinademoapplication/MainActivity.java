package com.example.carinademoapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    private Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextBtn = (Button) findViewById(R.id.next_button);
        nextBtn.setOnClickListener(this);
    }

    @Override
    public  void  onClick(View v) {
        switch (v.getId()) {
            case  R.id.next_button:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }
}
