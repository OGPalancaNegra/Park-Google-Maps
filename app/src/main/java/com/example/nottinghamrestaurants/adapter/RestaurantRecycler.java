package com.example.nottinghamrestaurants.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nottinghamrestaurants.R;
import com.example.nottinghamrestaurants.RestaurantFragment;
import com.example.nottinghamrestaurants.model.NottinghamRestaurants;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RestaurantRecycler extends RecyclerView.Adapter<RestaurantRecycler.ViewHolder> {


    private final List<NottinghamRestaurants> restaurantList;

    private final OnRestaurantClickListener restaurantClickListener;

   // private final OnParkClickListener parkClickListener;

    public RestaurantRecycler(List<NottinghamRestaurants> parkList, OnRestaurantClickListener restaurantClickListener) {
        this.restaurantList = parkList;
        this.restaurantClickListener = restaurantClickListener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.restaurant_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NottinghamRestaurants restaurants = restaurantList.get(position);
        holder.restaurantName.setText(restaurants.getBusinessName());
        holder.businessType.setText(restaurants.getBusinessType());
        holder.postcode.setText(restaurants.getPostCode());

        holder.restaurantImage.setImageResource(R.drawable.ic_launcher_foreground);



    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {// implements View.OnClickListener {
        public ImageView restaurantImage;
        public TextView restaurantName;
        public TextView businessType;
        public TextView postcode;
        OnRestaurantClickListener onRestaurantClickListener;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            restaurantImage = itemView.findViewById(R.id.row_restaurant_imageview);
            restaurantName = itemView.findViewById(R.id.row_restaurant_name_textview);
            businessType = itemView.findViewById(R.id.row_restaurant_type_textview);
            postcode = itemView.findViewById(R.id.row_restaurant_state_textview);
            this.onRestaurantClickListener = restaurantClickListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            NottinghamRestaurants currRestaurant = restaurantList.get(getAdapterPosition());
            onRestaurantClickListener.onRestaurantClick(currRestaurant);
        }

        /**@Override
        public void onClick(View view) {
            Park currPark = parkList.get(getAdapterPosition());
            onParkClickListener.onParkClicked(currPark);

        }*/
    }
}

