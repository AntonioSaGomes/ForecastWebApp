package com.ua.tqs_project_80124.repository;

import com.ua.tqs_project_80124.model.Weather;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface WeatherRepository extends MongoRepository<Weather, Integer>{
	
	List<Weather> findById(int id);

}
