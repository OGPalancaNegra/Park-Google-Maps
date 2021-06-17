package com.example.nottinghamrestaurants.util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class Util {
    public static final String SPOTS_URL = "https://developer.nps.gov/api/v1/parks?stateCode=AZ&api_key=sptqFvukvLzopBhlCAWusyNUI5wPgv28a3Gip6xp";

    public static String getParksUrl(String cityName) {
        return "https://wyre-data.p.rapidapi.com/restaurants/"+cityName+"/?rapidapi-key=228035bb51msh1fa0747c288bc78p107940jsndc744793e98a";

    }
    public static void hideSoftKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }
}
