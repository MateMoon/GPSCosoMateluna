package com.example.gpscoso;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.VideoView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    EditText txtLatitud, txtLongitud;
    GoogleMap mMap;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLatitud = findViewById(R.id.txt_Latitud);
        txtLongitud = findViewById(R.id.txt_Longitud);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        txtLatitud.setText(String.valueOf(latLng.latitude));
        txtLongitud.setText(String.valueOf(latLng.longitude));
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        txtLatitud.setText(String.valueOf(latLng.latitude));
        txtLongitud.setText(String.valueOf(latLng.longitude));
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);
        addMarker(-38.734069, -72.602283, "Sede de gorbea", R.raw.videito);
        addMarker(-39.817157, -73.233365, "Sede Valdivia", R.raw.videito);
        addMarker(-18.43233, -70.310443, "Sede Arica", R.raw.videito);
        addMarker(-20.218889, -70.141041, "Sede Iquique", R.raw.videito);
        addMarker(-23.634560, -70.394136, "Sede Antofa", R.raw.videito);
        addMarker(-29.901486, -71.260357, "Sede Serena", R.raw.videito);
        addMarker(-33.037293, -71.522302, "Sede Viña", R.raw.videito);
        addMarker(-33.555032, -70.622681, "Sede Santiago", R.raw.videito);
        addMarker(-35.428565, -71.672952, "Sede Talca", R.raw.videito);
        addMarker(-36.826197, -73.061623, "Sede Concepcion", R.raw.videito);
        addMarker(-37.473145, -72.354595, "Sede Angeles", R.raw.videito);
        addMarker(-40.571669, -73.137779, "Sede Osorno", R.raw.videito);
        addMarker(-43.472499, -72.929070, "Sede PuertoMontt", R.raw.videito);

        ;

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Integer videoResource = (Integer) marker.getTag();
                if (videoResource != null) {

                    String institutionName = marker.getTitle();


                    Intent intent = new Intent(MainActivity.this, video.class);
                    intent.putExtra("videoResource", videoResource);
                    intent.putExtra("institutionName", institutionName);
                    startActivity(intent);
                }
                return true;
            }
        });
    }

    private void addMarker(double latitude, double longitude, String title, int videoResource) {
        LatLng location = new LatLng(latitude, longitude);
        Marker marker = mMap.addMarker(new MarkerOptions().position(location).title(title));
        marker.setTag(videoResource);
    }
}
