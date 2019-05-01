/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ua.tqs_project_80124;

import com.ua.tqs_project_80124.model.Weather;
import com.ua.tqs_project_80124.service.WeatherService;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author sagomes
 */
public class UnitTest {
    
    
    private Weather instance;
    private WeatherService weatherService;
    
    public UnitTest() {
        weatherService = new WeatherService();
    }
    
    @BeforeEach
    public void setUp() {
    	instance = new Weather(9,10.2,12.3,"20-3-2016");     
    }
    
    @AfterEach
    public void tearDown() {
    	instance= null;
    }

   
   @Test
   public void testPersistence(){
       assertEquals(instance, weatherService.addWeather(instance));
   }
}
