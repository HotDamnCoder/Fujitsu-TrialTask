package com.fujitsu.trial_task.weather.weatherData;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {

    List<WeatherData> findByStationNameOrderByTimestampDesc(String stationName);

}
