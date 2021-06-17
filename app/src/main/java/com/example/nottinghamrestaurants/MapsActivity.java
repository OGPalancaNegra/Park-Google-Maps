package com.example.nottinghamrestaurants;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.nottinghamrestaurants.data.Repository;
import com.example.nottinghamrestaurants.model.NottinghamRestaurants;
import com.example.nottinghamrestaurants.model.RestaurantViewModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private List<NottinghamRestaurants> restaurantsList;

    private RestaurantViewModel restaurantViewModel;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        restaurantViewModel= new ViewModelProvider(this).get(RestaurantViewModel.class);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        BottomNavigationView bottomNavigationView =
                findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {

            Fragment selectedFragment = null;

            int id = item.getItemId();
            if (id == R.id.maps_nav_button){

                mMap.clear();
                getSupportFragmentManager().beginTransaction().replace(R.id.map, mapFragment).commit();
                mapFragment.getMapAsync(this);
                return true;

            } else if (id == R.id.location_nav_button){
                selectedFragment = RestaurantFragment.newInstance();


            }
            getSupportFragmentManager().beginTransaction().replace(R.id.map, selectedFragment).commit();


            //show the map view



            return true;
        });

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
        restaurantsList = new ArrayList<>();
        // clear list so list isent duplicated everytime we go back and forthe between frags
        restaurantsList.clear();

        // Add a marker in Sydney and move the camera
        //LatLng AbbeyfieldNottinghamSociety = new LatLng(52.989339, -1.036605);
       // mMap.addMarker(new MarkerOptions().position(AbbeyfieldNottinghamSociety).title("Abbeyfield Nottingham Society"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(AbbeyfieldNottinghamSociety));

        restaurantsList = new ArrayList<>();
        restaurantsList.clear();

        populateMap();


    }

    private void populateMap() {

        Repository.getRestaurants(restaurants ->{
            restaurantsList = restaurants;
            for (NottinghamRestaurants nottinghamRestaurants: restaurants){
                Log.d("Restaurants", "ONMAPREADY:"+ nottinghamRestaurants.getGeocodeLatitude().toString());
                LatLng restaurantsLatLon = new LatLng(nottinghamRestaurants.getGeocodeLatitude(), nottinghamRestaurants.getGeocodeLongitude());

                mMap.addMarker(new MarkerOptions().position(restaurantsLatLon).title(nottinghamRestaurants.getBusinessType()));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(restaurantsLatLon, 10));
            }
            restaurantViewModel.setSelectedRestaurants(restaurantsList);
        });
    }
}