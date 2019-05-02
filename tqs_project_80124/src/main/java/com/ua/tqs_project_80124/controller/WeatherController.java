package com.ua.tqs_project_80124.controller;

import com.ua.tqs_project_80124.Constants;
import com.ua.tqs_project_80124.model.Weather;
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
        private Constants localidades = new Constants();
        @RequestMapping("/")
        public String welcome(){
            return "Hello World!";
        }
        
        @GetMapping("/meteorologia/{localidade}")
        public String getWeatherByLocalidade(@PathVariable String localidade, Model model){
            for (String local:Constants.consts.keySet()){
                System.out.println(local + " " + localidade);
                if (local.equals(localidade)){
                    model.addAttribute("name",local);
                    System.out.println(Constants.consts.get(local));
                    model.addAttribute("weather",service.getWeatherByGlobalID(Constants.consts.get(local)));
                }
            }
            return "home";
        }
        
	@PostMapping(value = "/save")
	public Weather saveWeather(@RequestBody Weather weather) {
		return service.addWeather(weather);
	}

	@GetMapping("/getWeathers")
	public List<Weather> findAllWeathers() {
            return service.getWeathers();
	}

        @GetMapping(path = "/getAllWeathers", produces=MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Object>  getAllWeathers() {
            List<JSONObject> entities = new ArrayList<>();
            for (Weather weather:service.getWeathers()){
                JSONObject entity = new JSONObject();
                entity.put("tMax",weather.getTMax());
                entity.put("tMin",weather.getTMin());
                entities.add(entity);
            }
            return new ResponseEntity<>(entities,HttpStatus.OK);
        }

	@DeleteMapping(value="/remove")
	public Weather removeWeather(@RequestBody Weather weather) {
                for (Weather weather1:service.getWeathers()){
                    service.deleteWeather(weather1);
                }
		return weather; 
	}
        
        @GetMapping("/home")
        public String home(Model model){
            System.out.print(service.getWeathers());
            model.addAttribute("weather",service.getWeathers());
            return "home";
        }
        
        
}
