package com.example.nottinghamrestaurants;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nottinghamrestaurants.adapter.OnRestaurantClickListener;
import com.example.nottinghamrestaurants.adapter.RestaurantRecycler;
import com.example.nottinghamrestaurants.data.Repository;
import com.example.nottinghamrestaurants.model.NottinghamRestaurants;
import com.example.nottinghamrestaurants.model.RestaurantViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RestaurantFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RestaurantFragment extends Fragment implements OnRestaurantClickListener {

    private RecyclerView recyclerView;
    private RestaurantRecycler restaurantRecyclerViewAdapter;
    private List<NottinghamRestaurants> restaurantsList;
    private RestaurantViewModel restaurantViewModel;



    public RestaurantFragment() {
        // Required empty public constructor
    }

    public static RestaurantFragment newInstance() {
        RestaurantFragment fragment = new RestaurantFragment();
        Bundle args = new Bundle();
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // restaurantsList = new


    }

    //set up recycler on onViewCreated coz thats when the views are all set up and ready to go


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        restaurantViewModel= new ViewModelProvider(requireActivity()).get(RestaurantViewModel.class);

        if (restaurantViewModel.getRestaurants().getValue() != null)
        {
            restaurantsList = restaurantViewModel.getRestaurants().getValue();
            restaurantRecyclerViewAdapter = new RestaurantRecycler(restaurantsList, this);
            recyclerView.setAdapter(restaurantRecyclerViewAdapter);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_restaurant, container, false);

        recyclerView = view.findViewById(R.id.restaurant_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onRestaurantClick(NottinghamRestaurants nottinghamRestaurants) {
        Log.d("Restaurant", "onRestaurantClicked: " + nottinghamRestaurants.getBusinessName());
        restaurantViewModel.setSelectedRestaurant(nottinghamRestaurants);
        getFragmentManager().beginTransaction()
                .replace(R.id.restaurant_fragment, DetailsFragment.newInstance())
                .commit();
    }
}