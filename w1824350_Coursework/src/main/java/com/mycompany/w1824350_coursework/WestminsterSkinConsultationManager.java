/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w1824350_coursework;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author yahiy
 */
public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    private static Scanner input = new Scanner(System.in);
    public static ArrayList<Doctor> doctorList = new ArrayList<>();
    public static ArrayList<Patient> patientList = new ArrayList<>();
    public static ArrayList<Consultation> consultationList = new ArrayList<>();
    static SkinConsultationManager sys = new WestminsterSkinConsultationManager();
    
    @Override
    public void menu() {
        String choice;
        Boolean flag = false;
        System.out.println("""
                           Menu
                           
                           A: Add doctor
                           D: Delete doctor
                           L: List of doctors (sort list in alphabetical order by surname)
                           S: Save to file
                           O: Open GUI
                           
                           Q: Quit
                           """);
        System.out.print("Enter choice: ");
        choice = input.next();
        // Loop until valid input
        while (flag.equals(false)) {
            switch (choice.toUpperCase()) {
                case "A":
                    addDoctor();
                    flag = true;
                case "D":
                    deleteDoctor();
                    flag = true;
                case "L":
                    displayDoctors();
                    flag = true;
                case "S":
                    Boolean quitFlag = false;
                    save(quitFlag);
                    flag = true;
                case "O":
                    openGUI();
                    flag = true;
                    break;
                case "Q":
                    quit();
                default:
                    System.out.print("Please enter a valid option: ");
                    choice = input.next();
                    break;
            }
        }
    }
    
    @Override
    public void addDoctor() {
        String choice = "null";
        String forename;
        String surname;
        String day;
        String month;
        String year;
        String mobileNo;
        String medLicenceNo;
        String specialisation;
        
//        No more than 10 doctors allowed to be entered
        if (doctorList.size() < 10)
        {
            Doctor doctor = new Doctor();
            System.out.print("\nEnter forename: ");
            forename = input.next().toUpperCase();
            doctor.setForename(forename);

            System.out.print("Enter surname: ");
            surname = input.next().toUpperCase();
            doctor.setSurname(surname);

            System.out.println("\nDate of birth");
            System.out.print("Enter day: ");
            day = input.next();
            doctor.dateOfBirth.setDay(day);

            System.out.print("Enter month: ");
            month = input.next();
            doctor.dateOfBirth.setMonth(month);

            System.out.print("Enter year: ");
            year = input.next();
            doctor.dateOfBirth.setYear(year);

//            
            while (doctor.getMobileNo() == null)
            {
                System.out.print("\nEnter mobile number: ");
                mobileNo = input.next();
                doctor.setMobileNo(mobileNo);
            }

            System.out.print("\nEnter medical licence number: ");
            medLicenceNo = input.next();
            doctor.setMedLicenceNo(medLicenceNo);

            System.out.print("Enter specialisation: ");
            specialisation = input.next();
            doctor.setSpectialisation(specialisation);

            doctorList.add(doctor);
        } else {
            System.out.println("Maximum number of doctors reached. Delete a doctor to add a new one");
            menu();
        }

        while (!choice.toUpperCase().equals("Y") && !choice.toUpperCase().equals("N")) {
            System.out.print("\nWould you like to add a new doctor? (y/n) ");
            choice = input.next();
            if (choice.toUpperCase().equals("Y")) {
                addDoctor();
            } else if (choice.toUpperCase().equals("N")) {
                menu();
            } else {
                System.out.println("Enter either 'Y' for yes or 'N' for no");
            }
        }
    }
    
    @Override
    public void deleteDoctor() {
        String medLicenceNo;

        System.out.print("Enter medical licence number to remove doctor or 'C' to cancel: ");
        medLicenceNo = input.next();

        if (medLicenceNo.equals("C")) {
            menu();
        } else {
            Boolean found = false;

            for (int i = 0; i < doctorList.size(); i++) {
                if (medLicenceNo.equals(doctorList.get(i).getMedLicenceNo())) {
                    System.out.println("\nDoctor removed:\n" + doctorList.get(i));
                    doctorList.remove(i);
                    System.out.println("\nTotal number of doctors: " + doctorList.size() + "\n");
                    found = true;
                    menu();
                }
            }
            if (found.equals(false)) {
                System.out.println("Medical licence number not found");
                deleteDoctor();
            }
        }
    }
    
    @Override
    public void displayDoctors() {
        Doctor temp;
        int i = 0;
        int numItems = doctorList.size();
        Boolean flag = true;

        if (doctorList.isEmpty()) {
            System.out.println("List empty:");
            menu();
        } else {
            // Bubble sort
            while (i < (numItems - 1) && flag == true) {
                flag = false;
                for (int j = 0; j <= (numItems - i - 2); j++) {
                    if (doctorList.get(j).surname.charAt(0) > doctorList.get(j + 1).surname.charAt(0)) {
                        temp = doctorList.get(j);
                        doctorList.set(j, doctorList.get(j + 1));
                        doctorList.set(j + 1, temp);
                        flag = true;
                    }
                }
            }
        }

        // Output sorted arraylist
        for (int x = 0; x < doctorList.size(); x++) {
            System.out.println(doctorList.get(x) + "\n");
        }
        menu();
    }
    
    @Override
    public void save(Boolean quitFlag) {
        File file = new File("WestminsterConsultationDoctors.txt");
        try {
            FileOutputStream writeData = new FileOutputStream("WestminsterSkinConsultationDoctors.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(doctorList);
            writeStream.flush();
            writeStream.close();
            System.out.println("Data Stored\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (quitFlag == true)
        {
            System.out.println("Exiting program...");
            System.exit(0);
        } else {
            menu();
        }
    }
    
    @Override
    public void openGUI() {
        ConsultationFrame frame = new ConsultationFrame();
        
        frame.setTitle("Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 750);
        frame.setVisible(true);
    }
    
    @Override
    public void readDoctors() {
        try {
            File file = new File("WestminsterSkinConsultationDoctors.txt");
            FileInputStream readData = new FileInputStream("WestminsterSkinConsultationDoctors.txt");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            if (file.exists() && file.length() != 0) {
                ArrayList<Doctor> doctorList2 = (ArrayList<Doctor>) readStream.readObject();
                doctorList.addAll(doctorList2);
                System.out.println("\nDoctors found");
                
            } else if (file.exists() && file.length() == 0) {
                System.out.println("\nDoctors file empty");
                readPatients();
            }

            readStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            readPatients();
        }
        readPatients();
    }
    
    @Override
    public void readPatients() {
        try {
            File file = new File("WestminsterSkinConsultationPatients.txt");
            FileInputStream readData = new FileInputStream("WestminsterSkinConsultationPatients.txt");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            if (file.exists() && file.length() != 0) {
                ArrayList<Patient> patientList2 = (ArrayList<Patient>) readStream.readObject();
                patientList.addAll(patientList2);
                System.out.println("\nPatients found");
                
                System.out.println(patientList.toString());
                
            } else if (file.exists() && file.length() == 0) {
                System.out.println("\nPatients file empty");
                readConsultations();
            }

            readStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            readConsultations();
        }
        readConsultations();
    }
    
    @Override
    public void readConsultations() {
        try {
            File file = new File("WestminsterSkinConsultations.txt");
            FileInputStream readData = new FileInputStream("WestminsterSkinConsultations.txt");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            if (file.exists() && file.length() != 0) {
                ArrayList<Consultation> consultationList2 = (ArrayList<Consultation>) readStream.readObject();
                consultationList.addAll(consultationList2);
                System.out.println("\nConsultations found");
                
                System.out.println(consultationList.toString());
                
            } else if (file.exists() && file.length() == 0) {
                System.out.println("\nConsultations file empty");
                menu();
            }

            readStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            menu();
        }
        menu();
    }
    
    @Override
    public void quit() {
        String choice = "";
        while (!choice.toUpperCase().equals("Y") && !choice.toUpperCase().equals("N"))
        {
            System.out.print("Would you like to save any changes before you quit? (y/n) ");
            choice = input.next();
            if (choice.toUpperCase().equals("Y"))
            {
                Boolean quitFlag = true;
                save(quitFlag);
            } else if (choice.toUpperCase().equals("N"))
            {
                System.out.println("Exiting program...");
                System.exit(0);
            } else {
                System.out.println("Please enter a valid option");
            }
        }
    }
    
    public static void main(String[] args) {
        
        System.out.println("Westminster Skin Consultation Manager\n");
//        
        sys.readDoctors();
    }

}
