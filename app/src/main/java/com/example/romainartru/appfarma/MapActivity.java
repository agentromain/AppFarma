package com.example.romainartru.appfarma;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
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



        LatLng actual = new LatLng(37.197508, -3.624647);

        //mMap.moveCamera(CameraUpdateFactory.newLatLng(etsiit));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(actual, 16));

        MarkerOptions mOpt1 = new MarkerOptions();
        mOpt1.position(new LatLng(37.20,-3.625)).title("Farmacia 1");

        mMap.addMarker(mOpt1);
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent intent = new Intent(MapActivity.this, LoginActivity.class);
                switch(marker.getTitle()){
                    case "Farmacia 1":
                        intent.putExtra("idFarma", 1);

                        break;
                    case "Farmacia 2":
                        intent.putExtra("idFarma", 2);
                        break;
                    case "Farmacia 3":
                        intent.putExtra("idFarma", 3);
                        break;
                    case "Farmacia 4":
                        intent.putExtra("idFarma", 4);
                        break;
                    default :
                }
                startActivity(intent);
            }
        });

        MarkerOptions mOpt2 = new MarkerOptions();
        mOpt2.position(new LatLng(37.197,-3.623)).title("Farmacia 2");
        mMap.addMarker(mOpt2);

        MarkerOptions mOpt3 = new MarkerOptions();
        mOpt3.position(new LatLng(37.198,-3.6249)).title("Farmacia 3");
        mMap.addMarker(mOpt3);

        MarkerOptions mOpt4 = new MarkerOptions();
        mOpt4.position(new LatLng(37.199,-3.626)).title("Farmacia 4");
        mMap.addMarker(mOpt4);
    }
}
