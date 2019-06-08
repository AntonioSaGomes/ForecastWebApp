/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ua.tqs_project_80124.api;

import com.ua.tqs_project_80124.model.Weather;
import com.ua.tqs_project_80124.model.WeatherForecast;
import com.ua.tqs_project_80124.service.WeatherService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sagomes
 */

@RestController
@RequestMapping("/api")
public class WeatherApi {
    
    @Autowired
    private WeatherService weatherService;

    @RequestMapping(value = "/weathers",method = RequestMethod.GET)
    public ResponseEntity<?>  getAllWeathers() {
        List <WeatherForecast> weathers = weatherService.getWeathers();
        if (weathers == null) {
            return new ResponseEntity("WeatherForecast not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(weathers, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/weathers/{localidade}",method = RequestMethod.GET)
    public ResponseEntity<?> getWeatherByLocal(@PathVariable String localidade) {
        WeatherForecast weathers = weatherService.getWeatherForecastByLocal(localidade);
        if (weathers == null) {
            return new ResponseEntity("WeatherForecast with name " + localidade 
                    + " not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(weathers, HttpStatus.OK);
    }

    @GetMapping("/home")
    public String helloWorld() {
    	return "Hello World";
    }
}

