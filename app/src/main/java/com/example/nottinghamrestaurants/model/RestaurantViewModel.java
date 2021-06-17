package com.example.nottinghamrestaurants.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class RestaurantViewModel extends ViewModel {
    private final MutableLiveData<NottinghamRestaurants> selectedRestaurant = new MutableLiveData<>();

    private final MutableLiveData<List<NottinghamRestaurants>> selectedRestaurants = new MutableLiveData<>();

    private final MutableLiveData<String> code = new MutableLiveData<>();

    public void setSelectedRestaurant(NottinghamRestaurants nottinghamRestaurants){
        selectedRestaurant.setValue(nottinghamRestaurants);

    }

    public LiveData<NottinghamRestaurants> getSelectedRestaurant() {
        return selectedRestaurant;
    }

    public void setSelectedRestaurants(List<NottinghamRestaurants> restaurants) {
        selectedRestaurants.setValue(restaurants);
    }

    public LiveData<List<NottinghamRestaurants>> getRestaurants() {
        return selectedRestaurants;
    }

    public LiveData<String> getCode() { return code; }
    public void selectCode(String c) {
        code.setValue(c);
    }

}
