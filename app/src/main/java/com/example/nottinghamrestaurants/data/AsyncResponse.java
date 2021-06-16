package com.example.nottinghamrestaurants.data;

import com.example.nottinghamrestaurants.model.ExampleList;
import com.example.nottinghamrestaurants.model.NottinghamRestaurants;

import java.util.ArrayList;
import java.util.List;

public interface AsyncResponse {
    void processRestaurants(List<NottinghamRestaurants> restaurants);
}
