package com.ua.tqs_project_80124.controller;

import com.ua.tqs_project_80124.Constants;
import com.ua.tqs_project_80124.model.Weather;
import com.ua.tqs_project_80124.model.WeatherForecast;
import com.ua.tqs_project_80124.service.WeatherService;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
    
@Controller
public class WeatherController {
    
	@Autowired
	private WeatherService service;
        
        private Constants localidades = new Constants();
        
        
        
        @GetMapping("/meteorologia")
        public String getWeatherByLocalidadeAndDay(@RequestParam String localidade,@RequestParam(value="day",required=false) Integer day, Model model){
            String templateName = "home";
            model.addAttribute("name",localidade);
            if (day == null){
                day = 0;
            }
            if (day>4){
                day=4;
            }
            model.addAttribute("weather",service.getWeatherForecastByLocal(localidade).getWeathers().get(day));
            return templateName;
        }
        
	@PostMapping(value = "/save")
	public WeatherForecast saveWeatherList(@RequestBody WeatherForecast weatherList) {
		return service.addWeather(weatherList);
	}
        
        @GetMapping("/cities")
        public String getAvailableCities(Model model){
            String templateName = "cities";
            model.addAttribute("cities",localidades.consts.keySet());
            return templateName;
        }
        
	@GetMapping("/getWeathers")
	public List<WeatherForecast> findAllWeathers() {
            return service.getWeathers();
	}

        
        @GetMapping(path = "/getAllWeathers", produces=MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Object>  getAllWeathers() {
            List<JSONObject> entities = new ArrayList<>();
            for (WeatherForecast weatherList:service.getWeathers()){
                for(Weather weather:weatherList.getWeathers()){
                    JSONObject entity = new JSONObject();
                    entity.put("tMax",weather.getTMax());
                    entity.put("tMin",weather.getTMin());
                    entities.add(entity);
                }
            }
            return new ResponseEntity<>(entities,HttpStatus.OK);
        }

        @GetMapping("/")
        public String home(Model model){
            System.out.print(service.getWeathers());
            model.addAttribute("weather",service.getWeathers().get(0).getWeathers().get(0));
            return "home";
        }
        
        
}
