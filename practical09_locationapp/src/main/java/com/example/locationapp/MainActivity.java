package com.example.locationapp;

import android.os.Bundle;
import android.Manifest;
import android.content.pm.PackageManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.GoogleMap;

public class MainActivity extends AppCompatActivity
        implements OnMapReadyCallback {

    GoogleMap map;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        SupportMapFragment f = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map);
        if (f != null) {
            f.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap m) {
        map = m;
        map.getUiSettings().setZoomControlsEnabled(true);
        map.getUiSettings().setMyLocationButtonEnabled(true);

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            map.setMyLocationEnabled(true);
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION
                    }, 1);
        }
    }

    @Override
    public void onRequestPermissionsResult(
            int c, String[] p, int[] g) {
        super.onRequestPermissionsResult(c, p, g);
        if (c == 1 && g.length > 0 &&
                g[0] == PackageManager.PERMISSION_GRANTED) {
            if (map != null) {
                onMapReady(map);
            }
        }
    }
}
