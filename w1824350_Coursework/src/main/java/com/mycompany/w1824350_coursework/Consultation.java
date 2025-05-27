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
public class Consultation implements Serializable {
    
    public Date date = new Date();
    public Time time;
    private double cost;
    private String notes;
    
    public Consultation() {
        
    }
    
    public Consultation(Date date, Time time, double cost, String notes) {
        this.date = date;
        this.time = time;
        this.cost = cost;
        this.notes = notes;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setTime(Time time) {
        this.time = time;
    }
    
    public Time getTime() {
        return time;
    }
    
    public void setCost(int cost) {
        this.cost = cost;
    }
    
    public double getcost() {
        return cost;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public String getNotes() {
        return notes;
    }
    
    @Override
    public String toString() {
        return "Date: " + date + "\nTime: " + time + "\nCost: " + cost + "\nNotes: " + notes;
    }
}
