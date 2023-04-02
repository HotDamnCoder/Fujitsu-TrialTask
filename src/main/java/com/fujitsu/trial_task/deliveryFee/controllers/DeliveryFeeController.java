package com.fujitsu.trial_task.deliveryFee.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fujitsu.trial_task.deliveryFee.services.DeliveryFeeService;
import com.fujitsu.trial_task.deliveryFee.exceptions.DeliveryDataNotFoundException;
import com.fujitsu.trial_task.deliveryFee.models.DeliveryFee;
import com.fujitsu.trial_task.weather.entities.WeatherData;
import com.fujitsu.trial_task.weather.repositories.WeatherDataRepository;

@RestController
public class DeliveryFeeController {

	private final WeatherDataRepository repository;

	public DeliveryFeeController(WeatherDataRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/deliveryFee")
	public DeliveryFee deliverFee(
			@RequestParam(required = true) String location,
			@RequestParam(required = true) String vehicleType) {

		List<WeatherData> weatherDatas = repository.findByStationNameOrderByTimestampDesc(location.toLowerCase());

		if (weatherDatas.isEmpty()){
			throw new DeliveryDataNotFoundException();
		}

		WeatherData weatherData = weatherDatas.get(0);
		Double RBF = DeliveryFeeService.calculateRBF(location, vehicleType);
		Double ATEF = DeliveryFeeService.calculateATEF(vehicleType, weatherData.getAirTemp());
		Double WSEF = DeliveryFeeService.calculateWSEF(vehicleType, weatherData.getWindSpeed());
		Double WPEF = DeliveryFeeService.calculateWPEF(vehicleType, weatherData.getPhenomenon());

		return DeliveryFeeService.calculateDeliveryFee(RBF, ATEF, WSEF, WPEF);

	}
}
