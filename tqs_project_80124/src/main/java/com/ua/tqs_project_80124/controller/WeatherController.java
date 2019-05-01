package com.ua.tqs_project_80124.controller;

import com.ua.tqs_project_80124.model.Weather;
import com.ua.tqs_project_80124.service.WeatherService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
    
@Controller
public class WeatherController {
	@Autowired
	private WeatherService service;

        @RequestMapping("/")
        public String welcome(){
            return "Hello World!";
        }
        
	@PostMapping(value = "/save")
	public Weather saveWeather(@RequestBody Weather weather) {
		return service.addWeather(weather);
	}

	@GetMapping("/getWeathers")
	public List<Weather> findAllWeathers() {
		return service.getWeathers();
	}

	@GetMapping("/getWeatherByID{id}")
	public List<Weather> findWeatherBy_id(@PathVariable int id) {
		return service.getWeatherByID(id);
	}

	@DeleteMapping(value="/remove")
	public Weather removeWeather(@RequestBody Weather weather) {
		service.deleteWeather(weather);
		return weather; 
	}
        
        @GetMapping("/home")
        public String home(Model model){
            model.addAttribute("home",service.getWeathers());
            return "home";
        }
}
