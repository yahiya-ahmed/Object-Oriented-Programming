/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w1824350_coursework;

/**
 *
 * @author yahiy
 */
public class Doctor extends Person {
    
    protected String medLicenceNo;
    protected String specialisation;
    
    public Doctor() {
        
    }
    
    public Doctor(String medLicenceNo, String specialisation) {
        this.medLicenceNo = medLicenceNo;
        this.specialisation = specialisation;
    }
    
    public void setMedLicenceNo(String medLicenceNo) {
        this.medLicenceNo = medLicenceNo;
    }
    
    public String getMedLicenceNo() {
        return medLicenceNo;
    }
    
    public void setSpectialisation(String specialisation) {
        this.specialisation = specialisation;
    }
    
    public String getSpectialisation() {
        return specialisation;
    }
    
    @Override
    public String toString() {
        return "Forename : " + forename + "\nSurname: " + surname + "\nDate of Birth: " + dateOfBirth.toString() + "\nMobile Number: " + mobileNo + "\nMedical licence number: " + medLicenceNo + "\nSpecialisation: " + specialisation;
    }
    
}
