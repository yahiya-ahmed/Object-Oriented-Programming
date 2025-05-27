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
public class Time implements Serializable {
    
    private int hour;
    private int minute;
    
    public Time() {
        
    }
    
    public Time(int hour, int minute) {
        
    }
    
    public void setHour(int hour) {
        this.hour = hour;
    }
    
    public int getHour() {
        return hour;
    }
    
    public void setMinute(int minute) {
        this.minute = minute;
    }
    
    public int getMinute() {
        return minute;
    }
    
    public void setTime(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }
    
    public int getTime() {
        return hour+minute;
    }
    
    @Override
    public String toString() {
        return hour+":"+minute;
    }
    
}
