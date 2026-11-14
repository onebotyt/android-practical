package com.example.cameraapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    ActivityResultLauncher<Intent> camera;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.image);

        camera = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK &&
                            result.getData() != null &&
                            result.getData().getExtras() != null) {
                        Bitmap photo = (Bitmap) result.getData()
                                .getExtras().get("data");
                        image.setImageBitmap(photo);
                    }
                });

        findViewById(R.id.capture).setOnClickListener(v ->
                camera.launch(new Intent(MediaStore.ACTION_IMAGE_CAPTURE)));
    }
}
