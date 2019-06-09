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
import org.junit.runner.RunWith;

import static org.junit.Assert.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author sagomes
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitTesting {
    
    private WeatherForecast weatherForecast;
    private ArrayList<Weather> weathers;
    private ArrayList<WeatherForecast> weatherForecasts;
    
    @Autowired
    private WeatherService weatherService;
    
    @Autowired
    private WeatherRepository weatherRepository;

    
    @Before
    public void setUp(){
        weathers = new ArrayList<>();
        weatherForecasts = new ArrayList<>();
        weathers.add(new Weather(1L,2,3,"12-06-2019",9));
        weatherForecast = new WeatherForecast(weathers, "Aveiro", 1L, 8);
        weatherForecasts.add(weatherForecast);

    }
    

    
    @Test
    public void testSavingWeatherForecast (){
        assertThat(weatherForecast,equalTo(weatherService.addWeather(weatherForecast)));
    }
    
    @Test
    public void weathersRepoSize(){
        assertThat(weatherRepository.findAll().size(),equalTo(1));
    }
    

}
