package com.ua.tqs_project_80124.service;

import com.ua.tqs_project_80124.model.Weather;
import com.ua.tqs_project_80124.repository.WeatherRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class WeatherService {

	@Autowired
	private  WeatherRepository repository;
	
	public Weather addWeather(Weather weather) {
            System.out.println(weather);
            return repository.save(weather);
	}

	public List<Weather> getWeathers() {
		List<Weather> weathers = repository.findAll();
		System.out.println("Getting data from DB : " + weathers);
		return weathers;
	}

	public List<Weather> getWeatherByGlobalID(int globalId) {
		return repository.findByGlobalId(globalId);
	}

	public void deleteWeather(Weather weather) {
		repository.delete(weather);
	}
        
        public void deleteWeathers(){
            repository.deleteAll();
        }
}
