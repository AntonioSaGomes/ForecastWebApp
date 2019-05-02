/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ua.tqs_project_80124;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author sagomes
 */
public class Constants {
    
    public static Map<String,Integer> consts = new HashMap<>();
    public static int Aveiro = 1010500;
    public static int Beja = 1020500;
    public static int Braga = 1030300;
    public static int CasteloBranco = 1050200;
    public static final int Coimbra = 1060300;
    public static final int Evora = 1070500;
    
    public Constants(){
        consts.put("Aveiro", Aveiro);
        consts.put("Beja", Beja);
        consts.put("Braga",Braga);
        consts.put("CasteloBranco",CasteloBranco);
        consts.put("Coimbra", Coimbra);
        consts.put("Evora", Evora);
    }
   
    public static long generateId(){
        long hash = 7;
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int r = random.nextInt();
            hash = hash*31 + r;
        }
        return hash;
    }
}
