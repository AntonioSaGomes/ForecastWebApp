/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ua.tqs_project_80124;

import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author sagomes
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebInterfaceTest {
    
    @Autowired
    private MockMvc mvc;
    
    @Test
    public void getWeather() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.ALL)).andExpect(status().isOk())
                .andExpect((ResultMatcher) content().string(equalTo("Hello")));
        
    }
}
