package com.fujitsu.trial_task.weather.weatherData;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "weather_info")
@Table(name = "WEATHER_INFO")


public class WeatherData {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String stationName;

    private int stationWMO;

    private double airTemp;

    private double windSpeed;

    private String phenomenon;

    private long timestamp;

    public WeatherData() {
    }

    WeatherData(String stationName, int stationWMO, double airTemp, double windSpeed,
            String phenomenon, long timestamp) {
        this.stationName = stationName;
        this.stationWMO = stationWMO;
        this.airTemp = airTemp;
        this.windSpeed = windSpeed;
        this.phenomenon = phenomenon;
        this.timestamp = timestamp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String station_name) {
        this.stationName = station_name;
    }

    public int getStationWMO() {
        return stationWMO;
    }

    public void setStationWMO(int station_wmo) {
        this.stationWMO = station_wmo;
    }

    public double getAirTemp() {
        return airTemp;
    }

    public void setAirTemp(double air_temp) {
        this.airTemp = air_temp;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double wind_speed) {
        this.windSpeed = wind_speed;
    }

    public String getPhenomenon() {
        return phenomenon;
    }

    public void setPhenomenon(String phenomenon) {
        this.phenomenon = phenomenon;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "WeatherInfoEntity [id=" + id + ", stationName=" + stationName + ", stationWMO=" + stationWMO
                + ", airTemp=" + airTemp + ", windSpeed=" + windSpeed + ", phenomenon=" + phenomenon + ", timestamp="
                + timestamp + "]";
    }



}
