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
import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author sagomes
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitAndIntegrationTest {
    
    private WeatherForecast weatherForecast;
    private ArrayList<Weather> weathers;
    private ArrayList<WeatherForecast> weatherForecasts;
    private Weather weatherTest;
    @Autowired
    private WeatherService weatherService;
    
    @Autowired
    private WeatherRepository weatherRepository;

    
    @Before
    public void setUp(){
        weathers = new ArrayList<>();
        weatherForecasts = new ArrayList<>();
        weathers.add(new Weather(1L,2,3,"12-06-2019",9));
        weatherTest = new Weather();
        weatherTest.setId(2L);
        weatherTest.settMax(10.4);
        weatherTest.settMin(2.4);
        weatherTest.setGlobalId(Constants.AVEIRO);
        weatherTest.setForecastDate("14-06-2019");
        weathers.add(weatherTest);
        weatherForecast = new WeatherForecast(weathers, "Aveiro", 1L, 8);

    }
    

    
    @Test
    public void testSavingWeatherForecast (){
        assertThat(weatherForecast,equalTo(weatherService.addWeather(weatherForecast)));
    }
    
    @Test
    public void weathersRepoSize(){
        assertThat(weatherRepository.findAll().size(),equalTo(10));
    }
    
    @Test
    public void testWeatherRepository(){
        assertThat(weatherRepository.save(weatherForecast), equalTo(weatherForecast));
    }

    @Test
    public void testFindWeatherByCity(){
        assertThat(weatherRepository.findByGlobalId(1010500).getLocal(),equalTo("Aveiro"));
    }
    
    @Test 
    public void testWeatherForecast(){
        weatherForecast.addWeather(weatherTest);
        assertTrue(weatherForecast.saveWeathers(weathers).getWeathers().size()>0);
        assertTrue(weatherForecast.getWeathers().size()>0);
    }
    
    @Test
    public void testWeatherService(){
        assertThat(weatherRepository.findByGlobalId(1010500),equalTo(weatherService.getWeatherByGlobalID(1010500)));
        assertThat(weatherService.getWeatherForecastByLocal("Aveiro"), equalTo(weatherRepository.findByGlobalId(1010500)));
    }
    
    
}
