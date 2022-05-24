/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.purecloud.foldermaker;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
/**
 *
 * @author kh.wong
 */
public class DateTimeManage {

            
 public static void main(String[] args) {    
   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
   LocalDateTime today = LocalDateTime.now(); 
   LocalDateTime yesterday=today.minusDays(1);
   String strYesterday=dtf.format(yesterday)+"T00:00:00";
   String strToday=dtf.format(today)+"T00:00:00";
   String strInterval=strYesterday +"/"+strToday;
   System.out.println(strToday);  
   System.out.println(strYesterday); 
  System.out.println(strInterval);
  }    
}
