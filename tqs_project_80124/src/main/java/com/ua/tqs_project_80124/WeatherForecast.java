/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ua.tqs_project_80124;

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
        this.setId(this.weathers.get(1).getId());
        this.setGlobalID(this.weathers.get(1).getGlobalId());
        this.local = Constants.getLocal((int)globalID);
    }
    
    public void addWeather(Weather weather){
        this.weathers.add(weather);
        this.setId(weather.getId());
        this.setGlobalID(weather.getGlobalId());
    }

   
	public ArrayList<Weather> getWeathers() {
		return weathers;
	}

	public int getGlobalID() {
		return globalID;
	}

	public void setGlobalID(int globalID) {
		this.globalID = globalID;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public WeatherForecast(ArrayList<Weather> weathers, String local, Long id, int globalID) {
        this.weathers = weathers;
        this.local = local;
        this.id = id;
        this.globalID = globalID;
    }
    
}
