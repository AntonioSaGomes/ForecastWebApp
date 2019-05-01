package com.ua.tqs_project_80124;

import com.ua.tqs_project_80124.model.Weather;
import com.ua.tqs_project_80124.repository.WeatherRepository;
import com.ua.tqs_project_80124.service.WeatherService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.json.*;


@SpringBootApplication
@EnableScheduling
public class TqsProject80124Application implements CommandLineRunner {
    
	final static RestTemplate restTemplate = new RestTemplate();

        @Autowired
        private static WeatherService weatherService = new WeatherService();
        
	public static void main(String[] args) throws IOException {
		SpringApplication.run(TqsProject80124Application.class, args);
                URL url;
                try {
                    url = new URL("http://api.ipma.pt/open-data/forecast/meteorology/cities/daily/1010500.json");
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");
                    con.setDoOutput(true);
                    int status = con.getResponseCode();
                    BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuffer content = new StringBuffer();
                    while ((inputLine = in.readLine()) != null) {
                        content.append(inputLine);
                    }
                    in.close();
                    System.out.println(content.toString());
                    JSONObject obj = new JSONObject(content.toString());
                    JSONArray jsonArray = obj.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++){
                        double tMin = Double.parseDouble(jsonArray.getJSONObject(i).getString("tMin"));
                        double tMax = Double.parseDouble(jsonArray.getJSONObject(i).getString("tMax"));
                        String date = jsonArray.getJSONObject(i).getString("forecastDate");
                        Weather weather = new Weather(i,tMin,tMax,date);
                        System.out.println(weatherService.addWeather(weather));
                    }

                } catch (MalformedURLException ex) {
                    Logger.getLogger(TqsProject80124Application.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ProtocolException ex) {
                Logger.getLogger(TqsProject80124Application.class.getName()).log(Level.SEVERE, null, ex);
            }


        }

        @Override
        public void run(String... args) throws Exception {
            consumeWeathers(restTemplate, weatherService);
        }
        
        public static void consumeWeathers(RestTemplate restTemplate,WeatherService weatherService){
            String url = "http://api.ipma.pt/open-data/forecast/meteorology/cities/daily/1010500.json";
            final HttpEntity entity = new HttpEntity<String>("");
            ResponseEntity<Weather> responseEntity = restTemplate.exchange(url, HttpMethod.GET,entity,Weather.class);
            System.out.println(responseEntity.getBody());
        }
        
        
        public void parseJsonObject(){

        }

}
