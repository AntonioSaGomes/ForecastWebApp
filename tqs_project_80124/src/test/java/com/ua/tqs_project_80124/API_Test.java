/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ua.tqs_project_80124;

import com.ua.tqs_project_80124.service.WeatherService;
import java.net.URL;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author sagomes
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class API_Test {
    
    @LocalServerPort
    private int port=8080;
    
    private URL base;
    
    @Autowired
    private TestRestTemplate template;
    
    @Autowired
    private WeatherService weatherService;
    
    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/api");
       
    }
    
    @Test
    public void getWeatherLocal() throws Exception {
        String local = "Aveiro";
        ResponseEntity<String> response = template.getForEntity(base.toString() + "/getWeather/" + local, String.class);
        assertThat(response.getBody(),equalTo(weatherService.getWeatherByLocal(local)));
                
    }
}
