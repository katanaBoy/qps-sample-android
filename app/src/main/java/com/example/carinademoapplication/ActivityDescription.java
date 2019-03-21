package com.example.carinademoapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class ActivityDescription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        WebView myWebView = findViewById(R.id.webview);
        initWebView(myWebView);
    }

    private void initWebView(WebView myWebView) {
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl("https://www.carina-core.io");
    }
}
