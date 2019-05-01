package com.ua.tqs_project_80124.service;

import com.ua.tqs_project_80124.model.Weather;
import com.ua.tqs_project_80124.repository.WeatherRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

	@Autowired
	private WeatherRepository repository;
	

	public Weather addWeather(Weather weather) {
            return repository.save(weather);
	}

	public List<Weather> getWeathers() {
		List<Weather> weathers = repository.findAll();
		System.out.println("Getting data from DB : " + weathers);
		return weathers;
	}

	public List<Weather> getWeatherByID(int id) {
		return repository.findById(id);
	}

	public void deleteWeather(Weather weather) {
		repository.delete(weather);
	}
}
