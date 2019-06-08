package com.ua.tqs_project_80124;

import static com.ua.tqs_project_80124.Constants.consts;

import java.util.List;


import org.springframework.stereotype.Service;

@Service
public class WeatherService {

	
	private  WeatherRepository repository  =  new WeatherRepository();
	
	public WeatherForecast addWeather(WeatherForecast weatherList) {
            System.out.println(weatherList);
            return repository.save(weatherList);
	}

	public List<WeatherForecast> getWeathers() {
		List<WeatherForecast> weathers = repository.findAll();
		System.out.println("Getting data from DB : " + weathers);
		return weathers;
	}

	public WeatherForecast getWeatherByGlobalID(int globalId) {
		return repository.findByGlobalId(globalId);
	}
        
        public WeatherForecast getWeatherForecastByLocal(String localidade){
            for (String local:Constants.consts.keySet()){
                System.out.println(local + " " + localidade);
                if (local.equals(localidade)){
                    System.out.println(this.getWeatherByGlobalID(consts.get(local)));
                    return this.getWeatherByGlobalID(consts.get(local));
                }
            }
            return this.getWeathers().get(0);
        }
        
         public Weather getWeatherByLocalAndDay(String localidade,int day){
            for (String local:Constants.consts.keySet()){
                System.out.println(local + " " + localidade);
                if (local.equals(localidade)){
                    System.out.println(this.getWeatherByGlobalID(consts.get(local)));
                    return this.getWeatherByGlobalID(consts.get(local)).getWeathers().get(day);
                }
            }
            return this.getWeathers().get(0).getWeathers().get(day);
        }
        
}
