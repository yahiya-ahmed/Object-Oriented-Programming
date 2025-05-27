/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w1824350_coursework;

import java.io.*;

/**
 *
 * @author yahiy
 */
public class Date implements Serializable{
    
    private String day;
    private String month;
    private String year;
    
    public Date() {
        
    }
    
    public Date(String day, String month, String year) {
        
    }
    
    public void setDay(String day) {
        Boolean valid = true;
        
        if (day.length() == 2) {
            valid = day.matches("[0-9]+");
            if (valid == true) {
                try {
                    if (Integer.parseInt(day) >= 1 && Integer.parseInt(day) <= 31) {
                        this.day = day;
                    }
                } catch(NumberFormatException nfe) {
                    System.out.println("Integer between 1 and 31 required");
                    valid = false;
                    day = null;
                }
            } else {
                System.out.println("Integer between 1 and 31 required");
                day = null;
            }
        } else {
            valid = false;
            System.out.println("Integer between 1 and 31 required");
            day = null;
        }
    }
    
    public String getDay() {
        return day;
    }
    
    public void setMonth(String month) {
        this.month = month;
    }
    
    public String getMonth(){
        return month;
    }
    
    public void setYear(String year) {
        this.year = year;
    }
    
    public String getYear() {
        return year;
    }
    
    public void setDate(String day, String month, String year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public String getDate() {
        return "" + day+month+year;
    }
    
    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
    
}
