package com.fujitsu.trial_task.weather.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fujitsu.trial_task.weather.entities.WeatherData;

public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {

    List<WeatherData> findByStationNameOrderByTimestampDesc(String stationName);

}
