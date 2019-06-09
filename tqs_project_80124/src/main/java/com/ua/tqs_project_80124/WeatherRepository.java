package com.ua.tqs_project_80124;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class WeatherRepository {
    
    private List<WeatherForecast> weathersList;
    
    public WeatherRepository(){
        weathersList = new ArrayList<>();
    }
    
    public WeatherForecast save(WeatherForecast weatherList){
        this.weathersList.add(weatherList);
        return weatherList;
    }
     
    public WeatherForecast findById(long id){
        for (WeatherForecast weatherList:weathersList){
            if (weatherList.getId() == id){
                return weatherList;
            }
        }
        return weathersList.get(0);
    }

    public WeatherForecast findByGlobalId(long id){
        for (WeatherForecast weatherList:weathersList){
            if (weatherList.getGlobalID()== id){
                return weatherList;
            }
        }
        return weathersList.get(0);
    }
    
    public List<WeatherForecast> findAll(){
        return weathersList;
    }
}
