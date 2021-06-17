package com.example.nottinghamrestaurants.data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.nottinghamrestaurants.controller.AppController;
import com.example.nottinghamrestaurants.model.NottinghamRestaurants;
import com.example.nottinghamrestaurants.util.Util;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    static List<NottinghamRestaurants> restaurantList = new ArrayList<>();
    public static void getRestaurants(final AsyncResponse callback, String cityName) {
        String url = Util.getParksUrl(cityName);
        Log.d("URL", "getRestaurants: " + url);
        JsonArrayRequest jsonArrayRequest =
                new JsonArrayRequest(Request.Method.GET, url, null, response -> {


                    // response.getJSONObject(2).put("Geocode_Latitude", 300.3);
                    //response.getJSONObject(16).put("Geocode_Latitude", 400);
                    response.remove(16);
                    response.remove(2);

                    //if JSON OBJECT DOSENT HAVE A GEOLOCATION KEY DELETE

                    // OR IF HAS LOCATION VALUE GET

                    try {
                        //JSONArray jsonArray = response.getJSONArray("data");
                        for (int i = 0; i < response.length() ; i++) {
                            NottinghamRestaurants restaurants = new NottinghamRestaurants();


                            JSONObject restaurantObjects = response.getJSONObject(i);
                          //  park.setId(jsonObject.getString("id"));
                            //park.setBusinessName(jsonObject.getString("BusinessName"));

                            //only get objects with GeoLocation

                            restaurants.setGeocodeLatitude(Double.valueOf(restaurantObjects.getString("Geocode_Latitude")));

                            restaurants.setGeocodeLongitude(Double.valueOf(restaurantObjects.getString("Geocode_Longitude")));

                            restaurants.setBusinessName(restaurantObjects.getString("BusinessName"));

                            restaurants.setBusinessType(restaurantObjects.getString("BusinessType"));

                            restaurants.setPostCode(restaurantObjects.getString("PostCode"));

                            restaurants.setLocalAuthorityName(restaurantObjects.getString("LocalAuthorityName"));

                            restaurants.setRatingValue(Integer.valueOf(restaurantObjects.getString("RatingValue")));

                           // park.code(jsonObject.getString("parkCode"));
                            //park.setStates(jsonObject.getString("states"));

                            /**
                            park.setImages(list);

                           park.setWeatherInfo(jsonObject.getString("weatherInfo"));
                            park.setName(jsonObject.getString("name"));
                            park.setDesignation(jsonObject.getString("designation"));

                            //Setup Activities


                            //Topics
                            JSONArray topicsArray = jsonObject.getJSONArray("topics");
                            List<Topics> topicsList = new ArrayList<>();
                            for (int j = 0; j < topicsArray.length() ; j++) {
                                Topics topics = new Topics();
                                topics.setId(topicsArray.getJSONObject(j).getString("id"));
                                topics.setName(topicsArray.getJSONObject(j).getString("name"));
                                topicsList.add(topics);

                            }
                            park.setTopics(topicsList);

                            //Operating Hours
                            JSONArray opHours = jsonObject.getJSONArray("operatingHours");
                            List<OperatingHours> operatingHours = new ArrayList<>();
                            for (int j = 0; j < opHours.length() ; j++) {
                                OperatingHours op = new OperatingHours();
                                op.setDescription(opHours.getJSONObject(j).getString("description"));
                                StandardHours standardHours = new StandardHours();
                                JSONObject hours = opHours.getJSONObject(j).getJSONObject("standardHours");

                                standardHours.setWednesday(hours.getString("wednesday"));
                                standardHours.setMonday(hours.getString("monday"));
                                standardHours.setThursday(hours.getString("thursday"));
                                standardHours.setSunday(hours.getString("sunday"));
                                standardHours.setTuesday(hours.getString("tuesday"));
                                standardHours.setFriday(hours.getString("friday"));
                                standardHours.setSaturday(hours.getString("saturday"));
                                op.setStandardHours(standardHours);

                                operatingHours.add(op);

                            }

                            park.setOperatingHours(operatingHours);

                            park.setDirectionsInfo(jsonObject.getString("directionsInfo"));

                            park.setDescription(jsonObject.getString("description"));


                            //Entrance fees
                            JSONArray entranceFeesArray = jsonObject.getJSONArray("entranceFees");
                            List<EntranceFees> entranceFeesList = new ArrayList<>();
                            for (int j = 0; j < entranceFeesArray.length() ; j++) {
                                EntranceFees entranceFees = new EntranceFees();
                                entranceFees.setCost(entranceFeesArray.getJSONObject(j).getString("cost"));
                                entranceFees.setDescription(entranceFeesArray.getJSONObject(j).getString("description"));
                                entranceFees.setTitle(entranceFeesArray.getJSONObject(j).getString("title"));
                                entranceFeesList.add(entranceFees);

                            }
                            park.setEntranceFees(entranceFeesList);
                            park.setWeatherInfo(jsonObject.getString("weatherInfo"));



                             */

                            restaurantList.add(restaurants);

                        }
                        if (null != callback) { callback.processRestaurants(restaurantList);}

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }, error ->  {
                    error.printStackTrace();
                });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);
    }
}
