/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.examples3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author kh.wong
 */
public class Example3 {
     public static void main(String[] args) {    
   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
   LocalDateTime now = LocalDateTime.now();  
   System.out.println(dtf.format(now));  

  }     
}
