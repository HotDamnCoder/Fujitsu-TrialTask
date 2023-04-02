package com.fujitsu.trial_task.weather.weatherData;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherDataService {

    private final WeatherDataRepository repository;

    private final static String URL = "https://www.ilmateenistus.ee/ilma_andmed/xml/observations.php";

    private final static List<String> MONITORED_STATIONS = List.of("tallinn-harku", "tartu-tõravere", "pärnu");
    private final static List<String> REAL_LOCATIONS_OF_STATIONS = List.of("tallinn", "tartu-tõravere");

    public WeatherDataService(WeatherDataRepository repository) {
        this.repository = repository;
    }

    @Scheduled(fixedDelay = 5000)
    public void importWeatherData() {

        RestTemplate restTemplate = new RestTemplate();

        String contentString = restTemplate.getForObject(URL, String.class);

        JSONObject contentJSON = XML.toJSONObject(contentString);

        JSONObject observations = contentJSON.getJSONObject("observations");

        Long timestamp = observations.getLong("timestamp");

        JSONArray stations = observations.getJSONArray("station");

        for (int i = 0; i < stations.length(); i++) {
            JSONObject station = stations.getJSONObject(i);
            String stationName = station.getString("name").toLowerCase();
            if (MONITORED_STATIONS.contains(stationName)) {
                if (MONITORED_STATIONS.indexOf(stationName) < REAL_LOCATIONS_OF_STATIONS.size()) {
                    stationName = REAL_LOCATIONS_OF_STATIONS.get(MONITORED_STATIONS.indexOf(stationName)).toLowerCase();
                }
                int stationWMO = station.getInt("wmocode");
                double airTemp = station.getDouble("airtemperature");
                double windSpeed = station.getDouble("windspeed");
                String phenomenon = station.getString("phenomenon");
                WeatherData weather_data = new WeatherData(stationName, stationWMO, airTemp, windSpeed, phenomenon,
                        timestamp);
                System.out.println(weather_data.toString());
                repository.save(weather_data);
            }
        }

    }

}
