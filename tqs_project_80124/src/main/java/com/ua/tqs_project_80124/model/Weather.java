package com.ua.tqs_project_80124.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "new_weathers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Weather {
	@Id
        private int id;
	private double tMin;
	private double tMax;
	private String forecastDate;

        
}


