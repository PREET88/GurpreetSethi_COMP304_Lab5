package com.example.gurpreet.gurpreetsethi_comp304_lab5;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
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
        Resources res = getResources();
        Intent intent = getIntent();

        String id = intent.getStringExtra("Marker");
        String str=intent.getStringExtra("Satellite");

        if(str.equals("Yes"))
            mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        LatLng restaurant;
        if (id.equals("Burger king")){

            restaurant = new LatLng(43.7229896,-79.3007813);
            mMap.addMarker(new MarkerOptions().position(restaurant).title(id));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(restaurant));
        }

         else if (id.equals("Tim Hortons")) {
            restaurant = new LatLng(43.704926, -79.282280);
            mMap.addMarker(new MarkerOptions().position(restaurant).title(id));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(restaurant));
        }else if (id.equals("Hakka Legend")) {
            restaurant = new LatLng(45.4215296, -75.6971931);
            mMap.addMarker(new MarkerOptions().position(restaurant).title(id));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(restaurant));

        }

        else if (id.equals("Kwality Foods")) {
            restaurant = new LatLng(43.7229996, -79.3008313);
            mMap.addMarker(new MarkerOptions().position(restaurant).title(id));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(restaurant));

        }else if (id.equals("Tasty Foods")) {
            restaurant = new LatLng(43.761539, -79.411079);
            mMap.addMarker(new MarkerOptions().position(restaurant).title(id));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(restaurant));

        }else if (id.equals("China Town")) {
            restaurant = new LatLng(43.642567, -76.387054);
            mMap.addMarker(new MarkerOptions().position(restaurant).title(id));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(restaurant));

        }else if (id.equals("Federick")) {
            restaurant = new LatLng(43.7749574, -79.240945);
            mMap.addMarker(new MarkerOptions().position(restaurant).title(id));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(restaurant));

        }else if (id.equals("Moti Mahal")) {
            restaurant = new LatLng( 53.631611, -113.323975);
            mMap.addMarker(new MarkerOptions().position(restaurant).title(id));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(restaurant));

        }

    }
}
