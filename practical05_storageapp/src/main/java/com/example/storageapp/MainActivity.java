package com.example.storageapp;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.io.*;

public class MainActivity extends AppCompatActivity {
    EditText input;
    TextView output;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);
        output = findViewById(R.id.output);

        findViewById(R.id.save).setOnClickListener(v -> saveData());
        findViewById(R.id.read).setOnClickListener(v -> readData());
    }

    void saveData() {
        try (FileOutputStream f = openFileOutput("data.txt", MODE_PRIVATE)) {
            f.write(input.getText().toString().getBytes());
            Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            output.setText("Save failed");
        }
    }

    void readData() {
        try (FileInputStream f = openFileInput("data.txt")) {
            byte[] data = new byte[f.available()];
            f.read(data);
            output.setText(new String(data));
        } catch (IOException e) {
            output.setText("No saved data found");
        }
    }
}
