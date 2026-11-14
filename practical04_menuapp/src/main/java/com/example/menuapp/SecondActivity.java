package com.example.menuapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_second);

        String page = getIntent().getStringExtra("page");
        ((TextView) findViewById(R.id.pageText)).setText(page + " Screen");
    }
}
