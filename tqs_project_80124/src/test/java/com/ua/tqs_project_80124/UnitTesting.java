/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ua.tqs_project_80124;

import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author sagomes
 */
public class UnitTesting {
    
    private WeatherForecast weatherForecast;
    private WeatherRepository weatherRepository;
    private ArrayList<Weather> weathers;
    private ArrayList<WeatherForecast> weatherForecasts;
    
    @Autowired
    private WeatherService weatherService;
    
    
    @Before
    public void setUp(){
        weathers = new ArrayList<>();
        weatherForecasts = new ArrayList<>();
        weathers.add(new Weather(1L,2,3,"12-06-2019",9));
        weatherForecast = new WeatherForecast(weathers, "Aveiro", 1L, 8);
        weatherRepository = new WeatherRepository();
        weatherRepository.save(weatherForecast);

    }
    
    @Test
    public void testSavingWeatherForecast (){
        assertThat(weatherForecast,equalTo(weatherRepository.save(weatherForecast)));
    }
    
    @Test
    public void weathersRepoSize(){
        assertThat(weatherRepository.findAll().size(),equalTo(1));
        weatherRepository.save(weatherForecast);
        assertThat(weatherRepository.findAll().size(),equalTo(2));
    }
    

}
