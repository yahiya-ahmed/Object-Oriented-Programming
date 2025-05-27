/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w1824350_coursework;

/**
 *
 * @author yahiy
 */
public class Patient extends Person {
    
    protected String patientID;
    
    public Patient() {
        
    }
    
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }
    
    public String getPatientID() {
        return patientID;
    }
    
    @Override
    public String toString() {
        return "Forename : " + forename + "\nSurname: " + surname + "\nDate of Birth: " + dateOfBirth.toString() + "\nMobile Number: " + mobileNo + "\nPatient ID: " + patientID;
    }
    
}
