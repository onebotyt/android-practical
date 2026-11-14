package com.example.locationapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {
    WebView map;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        map = findViewById(R.id.mapView);
        WebSettings s = map.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setDatabaseEnabled(true);
        s.setGeolocationEnabled(true);
        s.setBuiltInZoomControls(true);
        s.setDisplayZoomControls(false);

        map.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.startsWith("http://") || url.startsWith("https://")) {
                    view.loadUrl(url);
                }
                return true;
            }
        });

        map.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, false);
            }
        });

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
            }, 1);
        }

        loadMap();
    }

    void loadMap() {
        Location loc = null;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);
            if (lm != null) {
                loc = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if (loc == null) loc = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            }
        }

        String url = (loc != null)
                ? "https://maps.google.com/?q=" + loc.getLatitude() + "," + loc.getLongitude() + "&output=embed"
                : "https://maps.google.com/?output=embed";

        map.loadUrl(url);
    }

    @Override
    public void onRequestPermissionsResult(int c, String[] p, int[] g) {
        super.onRequestPermissionsResult(c, p, g);
        if (c == 1 && g.length > 0 && g[0] == PackageManager.PERMISSION_GRANTED) {
            loadMap();
        }
    }

    @Override
    public void onBackPressed() {
        if (map != null && map.canGoBack()) {
            map.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
