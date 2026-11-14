package com.example.menuapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.home) {
            return true;
        } else if (id == R.id.about) {
            openPage("About");
            return true;
        } else if (id == R.id.contact) {
            openPage("Contact");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    void openPage(String page) {
        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra("page", page);
        startActivity(i);
    }
}
