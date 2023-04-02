package com.fujitsu.trial_task.weather.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fujitsu.trial_task.weather.entities.WeatherData;

@Repository
public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {

    List<WeatherData> findFirstByStationNameOrderByTimestampDesc(String stationName);

}
