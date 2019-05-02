package com.ua.tqs_project_80124.model;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "new_weathers")
@Data
@NoArgsConstructor
@ToString
public class Weather {
	@Id
        private Long id;
	private double tMin;
	private double tMax;
	private String forecastDate;
        public int globalId;
        
       public Weather(Long id,double tMin,double tMax,String forecastDate,int globalId){
           this.id = id;
           this.tMin = tMin;
           this.tMax = tMax;
           this.globalId = globalId;
           this.forecastDate = forecastDate;
       }

       public void transformDate(String forecastDate){
            DateFormat formatter = new SimpleDateFormat("dd MMMM ");
            String[] arr = forecastDate.split("-");
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.set(Calendar.YEAR,Integer.parseInt(arr[0])-1);
            calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(arr[2])-1);
            calendar.set(Calendar.MONTH, Integer.parseInt(arr[1])-1);
            this.forecastDate = formatter.format(calendar.getTime());      
       }
}


