package com.ua.tqs_project_80124.model;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Weather {
       
        private Long id;
        private double tMin;
        private double tMax;
        private String forecastDate;
        private int globalId;
        
       public int getGlobalId() {
			return globalId;
		}

		public void setGlobalId(int globalId) {
			this.globalId = globalId;
		}


       public void transformDate(String forecastDate){
            DateFormat formatter = new SimpleDateFormat("dd MMMM ");
            String[] arr = forecastDate.split("-");
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.set(Calendar.YEAR,Integer.parseInt(arr[0])-1);
            calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(arr[2])-1);
            calendar.set(Calendar.MONTH, Integer.parseInt(arr[1])-1);
            this.setForecastDate(formatter.format(calendar.getTime()));      
       }

       public Weather(Long id, double tMin, double tMax, String forecastDate, int globalId) {
			super();
			this.id = id;
			this.tMin = tMin;
			this.tMax = tMax;
			this.forecastDate = forecastDate;
			this.globalId = globalId;
       }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double gettMin() {
		return tMin;
	}

	public void settMin(double tMin) {
		this.tMin = tMin;
	}

	public double gettMax() {
		return tMax;
	}

	public void settMax(double tMax) {
		this.tMax = tMax;
	}

	public String getForecastDate() {
		return forecastDate;
	}

	public void setForecastDate(String forecastDate) {
		this.forecastDate = forecastDate;
	}

       

}


