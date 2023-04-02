package com.fujitsu.trial_task.weather.entities;

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

    public WeatherData(String stationName, int stationWMO, double airTemp, double windSpeed,
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((stationName == null) ? 0 : stationName.hashCode());
        result = prime * result + stationWMO;
        long temp;
        temp = Double.doubleToLongBits(airTemp);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(windSpeed);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((phenomenon == null) ? 0 : phenomenon.hashCode());
        result = prime * result + (int) (timestamp ^ (timestamp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        WeatherData other = (WeatherData) obj;
        if (id != other.id)
            return false;
        if (stationName == null) {
            if (other.stationName != null)
                return false;
        } else if (!stationName.equals(other.stationName))
            return false;
        if (stationWMO != other.stationWMO)
            return false;
        if (Double.doubleToLongBits(airTemp) != Double.doubleToLongBits(other.airTemp))
            return false;
        if (Double.doubleToLongBits(windSpeed) != Double.doubleToLongBits(other.windSpeed))
            return false;
        if (phenomenon == null) {
            if (other.phenomenon != null)
                return false;
        } else if (!phenomenon.equals(other.phenomenon))
            return false;
        if (timestamp != other.timestamp)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "WeatherInfoEntity [id=" + id + ", stationName=" + stationName + ", stationWMO=" + stationWMO
                + ", airTemp=" + airTemp + ", windSpeed=" + windSpeed + ", phenomenon=" + phenomenon + ", timestamp="
                + timestamp + "]";
    }

}
