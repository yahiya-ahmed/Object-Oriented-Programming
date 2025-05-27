/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w1824350_coursework;

/**
 *
 * @author yahiy
 */
public interface SkinConsultationManager {
    public void menu();
    public void addDoctor();
    public void deleteDoctor();
    public void displayDoctors();
    public void save(Boolean quitFlag);
    public void openGUI();
    public void readDoctors();
    public void readPatients();
    public void readConsultations();
    public void quit();
}
