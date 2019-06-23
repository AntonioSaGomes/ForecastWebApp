package com.ua.tqs_project_80124;

import static com.ua.tqs_project_80124.Constants.consts;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

@Service
public class WeatherService {

	@Autowired
	private  WeatherRepository repository;
	
	public WeatherForecast addWeather(WeatherForecast weatherList) {
            return repository.save(weatherList);
	}

	public List<WeatherForecast> getWeathers() {
            return repository.findAll();
	}

	public WeatherForecast getWeatherByGlobalID(int globalId) {
            return repository.findByGlobalId(globalId);
	}
        
        public WeatherForecast getWeatherForecastByLocal(String localidade){
            for (String local:Constants.consts.keySet()){
                if (local.equals(localidade)){
                    return this.getWeatherByGlobalID(consts.get(local));
                }
            }
            return this.getWeathers().get(0);
        }
        
         public Weather getWeatherByLocalAndDay(String localidade,int day){
            for (String local:Constants.consts.keySet()){
                if (local.equals(localidade)){
                    return this.getWeatherByGlobalID(consts.get(local)).getWeathers().get(day);
                }
            }
            return this.getWeathers().get(0).getWeathers().get(day);
        }
        
}
