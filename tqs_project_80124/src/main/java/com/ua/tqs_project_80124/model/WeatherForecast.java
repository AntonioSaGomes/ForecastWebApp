/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ua.tqs_project_80124.model;

import java.util.ArrayList;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author sagomes
 */
@Data
@ToString
public class WeatherForecast {
    
    private ArrayList<Weather> weathers;
    private String local;
    private Long id;
    private int globalID;
    
    public WeatherForecast(){
        weathers = new ArrayList<>();
    }
    
    public void saveWeathers(ArrayList<Weather> weatherList){
        this.weathers = weatherList;
        this.id = this.weathers.get(1).getId();
        this.globalID = this.weathers.get(1).getGlobalId();
    }
    
    public void addWeather(Weather weather){
        this.weathers.add(weather);
        this.id = weather.getId();
        this.globalID = weather.getGlobalId();
    }
    
}
