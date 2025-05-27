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
public abstract class Person implements Serializable {
    
    Boolean valid = true;
    protected String forename;
    protected String surname;
    protected Date dateOfBirth = new Date();
    protected String mobileNo = null;
    
    public Person() {
        
    }
    
    public Person(String forename, String surname, Date dateOfBirth, String mobileNo) {
        this.forename = forename;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.mobileNo = mobileNo;
    }
    
    public void setForename(String forename) {
        this.forename = forename;
    }
    
    public String getForename() {
        return forename;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public void setDoB(Date dateOfBirth) {
        
        this.dateOfBirth = dateOfBirth;
    }
    
    public Date getDoB() {
        return dateOfBirth;
    }
    
    public void setMobileNo(String mobileNo) {
        Boolean valid = true;   
        
        if (mobileNo.length() == 11) {
            valid = mobileNo.matches("[0-9]+");
        } else {
            valid = false;
        }
        
        if (valid == true)
        {
            this.mobileNo = mobileNo;
        } else {
            System.out.println("Mobile number is integers only and 11 digits");
            this.mobileNo = null;
        }
    }
    
    public String getMobileNo() {
        return mobileNo;
    }
    
    @Override
    public String toString(){
        return "Forename : " + forename + "\nSurname: " + surname + "\nDate of Birth: " + dateOfBirth.toString() + "\nMobile Number: " + mobileNo;
    }
    
}
