package com.example.nottinghamrestaurants;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nottinghamrestaurants.model.RestaurantViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailsFragment extends Fragment {

    private RestaurantViewModel restaurantViewModel;




    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        restaurantViewModel = new ViewModelProvider((requireActivity())).get(RestaurantViewModel.class);

        TextView businessName = view.findViewById(R.id.details_business_name_text_view);
        TextView businessType = view.findViewById(R.id.details_business_type_text_view);
        ImageView businessImage = view.getRootView().findViewById(R.id.details_business_image);
        TextView businessCity = view.getRootView().findViewById(R.id.details_business_city);
        TextView ratingValue = view.getRootView().findViewById(R.id.details_rating_value);
        TextView postcode = view.getRootView().findViewById(R.id.details_postcode);


        restaurantViewModel.getSelectedRestaurant().observe(getViewLifecycleOwner(), restaurants -> {
            businessName.setText(restaurants.getBusinessName());
            businessType.setText(restaurants.getBusinessType());
            businessImage.setImageResource(R.drawable.ic_launcher_foreground);
            businessCity.setText(restaurants.getLocalAuthorityName());
            postcode.setText(restaurants.getPostCode());
            ratingValue.setText(restaurants.getRatingValue().toString());


    });
    }

    public static DetailsFragment newInstance() {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }
}