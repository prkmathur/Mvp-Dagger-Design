package com.nh.themvpdesign.models;

import java.util.ArrayList;

/**
 * Created by admin on 17-Nov-17.
 */

public class WeatherData {

    ArrayList<ConsolidatedWeather> consolidated_weather;

    public ArrayList<ConsolidatedWeather> getConsolidatedWeathers() {
        return consolidated_weather;
    }

    public void setConsolidatedWeathers(ArrayList<ConsolidatedWeather> consolidatedWeathers) {
        this.consolidated_weather = consolidatedWeathers;
    }
}
