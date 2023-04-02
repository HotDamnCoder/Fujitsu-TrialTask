package com.fujitsu.trial_task.deliveryFee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fujitsu.trial_task.weather.weatherData.WeatherData;
import com.fujitsu.trial_task.weather.weatherData.WeatherDataRepository;

@RestController
public class DeliveryFeeController {

	private final WeatherDataRepository repository;

	public DeliveryFeeController(WeatherDataRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/deliveryFee")
	public DeliveryFee deliverFee(
			@RequestParam(defaultValue = "") String location,
			@RequestParam(defaultValue = "") String vehicleType) {

		WeatherData weather_info = repository.findByStationNameOrderByTimestampDesc(location.toLowerCase()).get(0);

		Double RBF = DeliveryFeeService.calculateRBF(location, vehicleType);
		Double ATEF = DeliveryFeeService.calculateATEF(vehicleType, weather_info.getAirTemp());
		Double WSEF = DeliveryFeeService.calculateWSEF(vehicleType, weather_info.getWindSpeed());
		Double WPEF = DeliveryFeeService.calculateWPEF(vehicleType, weather_info.getPhenomenon());

		return DeliveryFeeService.calculateDeliveryFee(RBF, ATEF, WSEF, WPEF);

	}
}
