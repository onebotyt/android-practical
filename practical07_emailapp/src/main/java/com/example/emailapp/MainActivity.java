package com.example.emailapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        EditText email = findViewById(R.id.email);
        EditText subject = findViewById(R.id.subject);
        EditText message = findViewById(R.id.message);

        findViewById(R.id.send).setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_SENDTO);
            i.setData(Uri.parse("mailto:"));
            i.putExtra(Intent.EXTRA_EMAIL,
                    new String[]{email.getText().toString()});
            i.putExtra(Intent.EXTRA_SUBJECT,
                    subject.getText().toString());
            i.putExtra(Intent.EXTRA_TEXT,
                    message.getText().toString());
            startActivity(Intent.createChooser(i, "Send Email"));
        });
    }
}
