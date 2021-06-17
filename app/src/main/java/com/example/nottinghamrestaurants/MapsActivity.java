package com.example.nottinghamrestaurants;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;

import com.example.nottinghamrestaurants.adapter.CustomInfoWindow;
import com.example.nottinghamrestaurants.data.Repository;
import com.example.nottinghamrestaurants.model.NottinghamRestaurants;
import com.example.nottinghamrestaurants.model.RestaurantViewModel;
import com.example.nottinghamrestaurants.util.Util;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private List<NottinghamRestaurants> restaurantsList;

    private RestaurantViewModel restaurantViewModel;

    private CardView cardView;

    private GoogleMap mMap;

    private EditText cityName;

    private ImageButton searchButton;
    private String code = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        restaurantViewModel= new ViewModelProvider(this).get(RestaurantViewModel.class);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        cardView = findViewById(R.id.cardview);
        cityName = findViewById(R.id.floating_state_value_et);
        searchButton = findViewById(R.id.floating_search_button);


        BottomNavigationView bottomNavigationView =
                findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {

            Fragment selectedFragment = null;

            int id = item.getItemId();
            if (id == R.id.maps_nav_button){
                if (cardView.getVisibility() == View.INVISIBLE ||
                        cardView.getVisibility() == View.GONE) {
                    cardView.setVisibility(View.VISIBLE);
                }


                mMap.clear();
                getSupportFragmentManager().beginTransaction().replace(R.id.map, mapFragment).commit();
                mapFragment.getMapAsync(this);
                return true;

            } else if (id == R.id.location_nav_button){
                selectedFragment = RestaurantFragment.newInstance();
                cardView.setVisibility(View.GONE);


            }
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.map, selectedFragment)
                    .commit();


            //show the map view



            return true;
        });

        searchButton.setOnClickListener(view -> {
            restaurantsList.clear();
            Util.hideSoftKeyboard(view);
            String stateCode = cityName.getText().toString().trim();
            if (!TextUtils.isEmpty(stateCode)) {
                code = stateCode;
                restaurantViewModel.selectCode(code);
                onMapReady(mMap); //refresh the map!
                cityName.setText("");
            }
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
        mMap.setInfoWindowAdapter(new CustomInfoWindow(getApplicationContext()));
        mMap.setOnInfoWindowClickListener(this);
        restaurantsList = new ArrayList<>();
        // clear list so list isent duplicated everytime we go back and forthe between frags
        restaurantsList.clear();

        populateMap();


    }

    private void populateMap() {
        mMap.clear();
        Repository.getRestaurants(restaurants ->{
            restaurantsList = restaurants;
            for (NottinghamRestaurants nottinghamRestaurants: restaurants){
                Log.d("Restaurants", "ONMAPREADY:"+ nottinghamRestaurants.getGeocodeLatitude().toString());
                LatLng restaurantsLatLon = new LatLng(nottinghamRestaurants.getGeocodeLatitude(), nottinghamRestaurants.getGeocodeLongitude());

                MarkerOptions markerOptions = new MarkerOptions().position(restaurantsLatLon)
                        .title(nottinghamRestaurants.getBusinessName())
                        .snippet(nottinghamRestaurants.getBusinessType());

                Marker marker = mMap.addMarker(markerOptions);
                marker.setTag(nottinghamRestaurants);

                //mMap.addMarker(markerOptions);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(restaurantsLatLon, 10));
            }
            restaurantViewModel.setSelectedRestaurants(restaurantsList);
        }, code);
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        // go to details fragmet
        cardView.setVisibility(View.GONE);
        //go to detailsFragment
        goToDetailsFragment(marker);

    }

    private void goToDetailsFragment(Marker marker) {
        restaurantViewModel.setSelectedRestaurant((NottinghamRestaurants) marker.getTag());
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.map, DetailsFragment.newInstance())
                .commit();
    }
}