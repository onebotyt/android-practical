package com.example.locationapp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;
import java.io.File;

public class MainActivity extends AppCompatActivity {
    MapView map;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);

        Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));
        Configuration.getInstance().setUserAgentValue("Mozilla/5.0 (Android; Mobile) AndroidPractical/1.0");
        Configuration.getInstance().setOsmdroidTileCache(new File(getCacheDir(), "map_tiles_clean"));

        setContentView(R.layout.activity_main);

        map = findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setMultiTouchControls(true);
        map.getController().setZoom(16.0);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
            }, 1);
        }

        MyLocationNewOverlay loc = new MyLocationNewOverlay(new GpsMyLocationProvider(this), map);
        loc.enableMyLocation();
        map.getOverlays().add(loc);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (map != null) map.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (map != null) map.onPause();
    }
}
