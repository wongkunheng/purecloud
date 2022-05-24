/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.DateManager;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

/**
 *
 * @author kh.wong
 */
public class DateTimeManage {

    private String strDate;

    public DateTimeManage(String strDateTime) {
        this.strDate = strDateTime;
    }

    // Get current system date 
    public  String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime today = LocalDateTime.parse(strDate,dtf);
        return dtf.format(today);
    }

    //Get string datetime interval format of current system date 
    public  String getIntervalDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime today =  LocalDateTime.parse(strDate,dtf);
        LocalDateTime yesterday = today.minusDays(1);
        String strYesterday = dtf.format(yesterday) + "T00:00:00";
        String strToday = dtf.format(today) + "T00:00:00";
        return strYesterday + "/" + strToday;
    }

  

    @Override
    public String toString() {
        return this.strDate;
    }
}
