package com.nh.themvpdesign.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConsolidatedWeather {

@SerializedName("id")
@Expose
private Long id;
@SerializedName("weather_state_name")
@Expose
private String weatherStateName;
@SerializedName("weather_state_abbr")
@Expose
private String weatherStateAbbr;
@SerializedName("wind_direction_compass")
@Expose
private String windDirectionCompass;
@SerializedName("created")
@Expose
private String created;
@SerializedName("applicable_date")
@Expose
private String applicableDate;
@SerializedName("min_temp")
@Expose
private Float minTemp;
@SerializedName("max_temp")
@Expose
private Float maxTemp;
@SerializedName("the_temp")
@Expose
private Float theTemp;
@SerializedName("wind_speed")
@Expose
private Float windSpeed;
@SerializedName("wind_direction")
@Expose
private Float windDirection;
@SerializedName("air_pressure")
@Expose
private Float airPressure;
@SerializedName("humidity")
@Expose
private Integer humidity;
@SerializedName("visibility")
@Expose
private Object visibility;
@SerializedName("predictability")
@Expose
private Integer predictability;

public Long getId() {
return id;
}

public void setId(Long id) {
this.id = id;
}

public String getWeatherStateName() {
return weatherStateName;
}

public void setWeatherStateName(String weatherStateName) {
this.weatherStateName = weatherStateName;
}

public String getWeatherStateAbbr() {
return weatherStateAbbr;
}

public void setWeatherStateAbbr(String weatherStateAbbr) {
this.weatherStateAbbr = weatherStateAbbr;
}

public String getWindDirectionCompass() {
return windDirectionCompass;
}

public void setWindDirectionCompass(String windDirectionCompass) {
this.windDirectionCompass = windDirectionCompass;
}

public String getCreated() {
return created;
}

public void setCreated(String created) {
this.created = created;
}

public String getApplicableDate() {
return applicableDate;
}

public void setApplicableDate(String applicableDate) {
this.applicableDate = applicableDate;
}

public Float getMinTemp() {
return minTemp;
}

public void setMinTemp(Float minTemp) {
this.minTemp = minTemp;
}

public Float getMaxTemp() {
return maxTemp;
}

public void setMaxTemp(Float maxTemp) {
this.maxTemp = maxTemp;
}

public Float getTheTemp() {
return theTemp;
}

public void setTheTemp(Float theTemp) {
this.theTemp = theTemp;
}

public Float getWindSpeed() {
return windSpeed;
}

public void setWindSpeed(Float windSpeed) {
this.windSpeed = windSpeed;
}

public Float getWindDirection() {
return windDirection;
}

public void setWindDirection(Float windDirection) {
this.windDirection = windDirection;
}

public Float getAirPressure() {
return airPressure;
}

public void setAirPressure(Float airPressure) {
this.airPressure = airPressure;
}

public Integer getHumidity() {
return humidity;
}

public void setHumidity(Integer humidity) {
this.humidity = humidity;
}

public Object getVisibility() {
return visibility;
}

public void setVisibility(Object visibility) {
this.visibility = visibility;
}

public Integer getPredictability() {
return predictability;
}

public void setPredictability(Integer predictability) {
this.predictability = predictability;
}

}