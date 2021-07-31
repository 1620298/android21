package com.example.practicacalificada2;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //direccion actual
        LatLng arequipa = new LatLng(-16.3989, -71.5369);
        mMap.addMarker(new MarkerOptions().position(arequipa).title("Arequipa, Peru"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(arequipa));


        //museo volcanes
        LatLng marcador1 = new LatLng(-16.4077539, -71.5486856);
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.
                fromResource(R.mipmap.ic_marcador)).anchor(0.0f, 1.0f).position(marcador1).title("Museo Volcanes"));
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);


        //museo volcanes
        LatLng marcador2 = new LatLng(-16.3951493, -71.5365666);
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.
                fromResource(R.mipmap.ic_marcador)).anchor(0.0f, 1.0f).position(marcador2).title("Santa Catalina"));
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);


        //cultural
        LatLng marcador3 = new LatLng(-16.3961651, -71.5327744);
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.
                fromResource(R.mipmap.ic_marcador)).anchor(0.0f, 1.0f).position(marcador3).title("Casa de La Cultura"));
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }
}